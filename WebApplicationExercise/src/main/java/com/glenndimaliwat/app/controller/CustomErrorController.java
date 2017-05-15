package com.glenndimaliwat.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class CustomErrorController implements ErrorController {

	@Autowired
	ErrorAttributes errorAttributes;
	
	private static final String ERROR_PATH = "/error";
	private static final String ERROR_PAGE = "views/customError";
	
	@RequestMapping(ERROR_PATH)
	public String showErrorPage( Model theModel, HttpServletRequest request) {
		
		Map<String, Object> theError = getErrorAttributes(request, true);
		
		theModel.addAttribute("timestamp", theError.get("timestamp"));
		theModel.addAttribute("status", theError.get("status"));
		theModel.addAttribute("error", theError.get("error"));
		theModel.addAttribute("message", theError.get("message"));
		theModel.addAttribute("path", theError.get("path"));
		
		return ERROR_PAGE;
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
	
	@RequestMapping("/404")
	public String pageNotFound(Model model,HttpServletRequest request){
		model.addAttribute("error", getErrorAttributes(request, true));
		return "404";
	}
	
	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return this.errorAttributes.getErrorAttributes(requestAttributes,includeStackTrace);
	}
	
}
