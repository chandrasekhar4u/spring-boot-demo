package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.examle.exception.MyException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler({Throwable.class})
    public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
        //If exception has a ResponseStatus annotation then use its response code
		System.out.println(ex.getMessage());
        ResponseStatus responseStatusAnnotation = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
        return buildModelAndViewErrorPage(request, response, ex, responseStatusAnnotation != null ? responseStatusAnnotation.value() : HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	private ModelAndView buildModelAndViewErrorPage(HttpServletRequest request, HttpServletResponse response, Exception ex, HttpStatus httpStatus) {
        response.setStatus(httpStatus.value());
        ModelAndView mav = new ModelAndView("errorpage");
        if (ex != null) {
            mav.addObject("title", ex);
        }
        mav.addObject("content", request.getRequestURL());
        return mav;
    }
	
	@ExceptionHandler({MyException.class})
    public String customExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		return "redirect:three.html";
    }

}
