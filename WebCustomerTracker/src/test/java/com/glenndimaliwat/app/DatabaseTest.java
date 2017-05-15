package com.glenndimaliwat.app;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTest {
	
	Connection myConn;
	
	@Before
	public void setupConnection() throws ClassNotFoundException, SQLException {
		// Setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		// Get connection to database
		System.out.println("Connecting to database: " + jdbcUrl);
		Class.forName(driver);
		myConn = DriverManager.getConnection(jdbcUrl, user, pass);
		
	}
	
	@Test
	public void testDatabase() throws SQLException {
		// Test if Database is Connected
		assertEquals(false, myConn.isClosed());
	}
	
	@After
	public void closeConnection() throws SQLException {
		myConn.close();
	}
}
