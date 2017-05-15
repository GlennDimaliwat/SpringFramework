package com.glenndimaliwat.app.domain;

import org.springframework.data.rest.core.config.Projection;

// Projection of Customer entity to view just the First Name and Last Name
@Projection( name="justnames", types = {Customer.class} )
public interface JustNames {
	
	String getFirstName();
	String getLastName();
	
}
