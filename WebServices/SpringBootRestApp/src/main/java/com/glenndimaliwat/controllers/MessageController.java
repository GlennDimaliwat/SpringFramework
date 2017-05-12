package com.glenndimaliwat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.glenndimaliwat.domain.Message;
import com.glenndimaliwat.service.MessageService;

@RestController
public class MessageController implements ErrorController {
	@Autowired
	MessageService messageService;
	
	@RequestMapping("/")
    public String welcome() {
        return "This is the Spring Boot Rest Web Service!";
    }
	
	@RequestMapping(value="/view/{idMessage}", method=RequestMethod.GET)
    public @ResponseBody Message viewMessage(@PathVariable int idMessage) {//REST Endpoint.
		return messageService.getMessage(idMessage);
    }
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
    public @ResponseBody String createMessage(@RequestBody Message msg) {//REST Endpoint.
		messageService.createMessage(msg);
		return "Message Created!";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.PUT)
    public @ResponseBody String updateMessage(@RequestBody Message msg) {//REST Endpoint.
		messageService.editMessage(msg);
		return "Message Edited!";
	}
	
	@RequestMapping(value="/delete/{idMessage}", method=RequestMethod.DELETE)
    public @ResponseBody String deleteMessage(@PathVariable int idMessage) {//REST Endpoint.
		messageService.deleteMessage(idMessage);
		return "Message "+idMessage+" Deleted!";
    }
	
	@RequestMapping(value="/viewAll", method=RequestMethod.GET)
    public @ResponseBody List<Message> viewAllMessages() {//REST Endpoint.
		return messageService.getAllMessages();
	}
	
	@RequestMapping(value="/error")
	public String error() {
		return "There was an error!";
	}
	@Override
    public String getErrorPath() {
		return "/error";
	}
}
