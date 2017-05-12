package com.glenndimaliwat.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "person")	// Remove if only JSON format is needed
public class Message {
	int id;
	String name;
    String text;
 
    public Message(){}
    
    public Message(int id, String name, String text) {
        this.id = id;
    	this.name = name;
        this.text = text;
    }
 
    //@XmlElement		// Remove if only JSON format is needed
    public int getId() {
        return id;
    }
    
    //@XmlElement		// Remove if only JSON format is needed
    public String getName() {
        return name;
    }
 
    //@XmlElement		// Remove if only JSON format is needed
    public String getText() {
        return text;
    }
}
