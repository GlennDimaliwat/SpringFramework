package com.glenndimaliwat.app.service;

import org.springframework.stereotype.Service;

import com.glenndimaliwat.app.domain.Message;

@Service
public class PageService {

	public Message createMessage() {
		return new Message("This is the message title", "This is the message body", "Glenn Dimaliwat");
	}

}
