package com.glenndimaliwat.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glenndimaliwat.domain.Message;

@RestController
public class MessageRestController {

	//Map to store persons, ideally we should use database
	Map<Integer, Message> msgData = new HashMap<Integer, Message>();

	
	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to Glenn's REST Service.";
    }
 
    /*@RequestMapping(value="/hello/{person}", method=RequestMethod.GET)
    public Message message(@PathVariable String person) {//REST Endpoint.
 
        Message msg = new Message(9999, person, "Hello " + person);
        return msg;
    }*/
    
	@RequestMapping(value="/create", method=RequestMethod.POST)
    public @ResponseBody Message createPerson(@RequestBody Message msg) {//REST Endpoint.
    	msgData.put(msg.getId(), msg);
        return msg;
    }
	
    @RequestMapping(value="/create", method=RequestMethod.PUT)
    public @ResponseBody Message updatePerson(@RequestBody Message msg) {//REST Endpoint.
    	msgData.put(msg.getId(), msg);
        return msg;
    }
    
    @RequestMapping(value="/viewAll", method=RequestMethod.GET)
    public @ResponseBody List<Message> viewAllMessages() {//REST Endpoint.
		List<Message> msgs = new ArrayList<Message>();
		Set<Integer> msgIdKeys = msgData.keySet();
		for(Integer i : msgIdKeys){
			msgs.add(msgData.get(i));
		}
		return msgs;
    }
    
    @RequestMapping(value="/view/{idMessage}", method=RequestMethod.GET)
    public @ResponseBody Message viewMessage(@PathVariable int idMessage) {//REST Endpoint.		
		return msgData.get(idMessage);
    }
    
    @RequestMapping(value="/delete/{idMessage}", method=RequestMethod.DELETE)
    public @ResponseBody Message deleteMessage(@PathVariable int idMessage) {//REST Endpoint.		
		return msgData.remove(idMessage);
    }
    
    
}
