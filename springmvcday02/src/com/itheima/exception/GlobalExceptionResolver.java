package com.itheima.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GlobalExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "您的网络连接有问题！");
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
