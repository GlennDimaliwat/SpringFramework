package com.glenndimaliwat.app.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

	@RequestMapping( value = "/acceptData", method = RequestMethod.POST )
	public ResponseEntity<Object> acceptData( @RequestBody Object body ) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		//responseHeaders.set
		//.setLocation(location);
		//responseHeaders.set("MyResponseHeader", "MyValue");
		
		// return body;
		
		// Return Response Entity insyead containing a body and http status 201
		return new ResponseEntity<Object>(body, responseHeaders, HttpStatus.CREATED);
	   
	}
}
