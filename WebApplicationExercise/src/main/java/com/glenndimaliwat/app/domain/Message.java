package com.glenndimaliwat.app.domain;

import java.util.Random;

public class Message {

	private int id;
	private String messageTitle;
	private String messageBody;
	private String author;
	
	public Message() {
		
	}
	
	public Message(String messageTitle, String messageBody, String author) {
		Random random = new Random();
		this.id = random.nextInt();
		this.messageTitle = messageTitle;
		this.messageBody = messageBody;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		Random random = new Random(); // Create a new Random ID
		this.id = random.nextInt();
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", messageTitle=" + messageTitle + ", messageBody=" + messageBody + ", author="
				+ author + "]";
	}	
	
}
