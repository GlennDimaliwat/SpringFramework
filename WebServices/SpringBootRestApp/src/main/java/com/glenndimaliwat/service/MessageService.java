package com.glenndimaliwat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.glenndimaliwat.domain.Message;

@Service
public class MessageService {
	
	//Map to store persons, ideally we should use database
	Map<Integer, Message> msgData = new HashMap<Integer, Message>();
	
	public void createMessage(Message msg) {
		msgData.put(msg.getId(), msg);
	}
	
	public void editMessage(Message msg) {
		msgData.put(msg.getId(), msg);
	}
	
	public void deleteMessage(int id) {
		msgData.remove(id);
	}

	public Message getMessage(int id) {
		return msgData.get(id);
	}
	
	public List<Message> getAllMessages() {
		List<Message> msgs = new ArrayList<Message>();
		Set<Integer> msgIdKeys = msgData.keySet();
		for(Integer i : msgIdKeys){
			msgs.add(msgData.get(i));
		}
		return msgs;
	}
	
}
