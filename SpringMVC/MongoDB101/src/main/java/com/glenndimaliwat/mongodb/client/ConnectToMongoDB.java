package com.glenndimaliwat.mongodb.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.bson.Document;

import com.glenndimaliwat.mongodb.model.Users;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class ConnectToMongoDB {

	Properties props = new Properties();
	MongoCredential credential;
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;
	
	private void initializeCredentials() {
		try {
			String resourceName = "Connection.properties";
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			
			try(InputStream propFile = loader.getResourceAsStream(resourceName)) {
			    props.load(propFile);
				System.out.println(props.getProperty("database"));
				System.out.println(props.getProperty("username"));
				System.out.println(props.getProperty("password"));
				System.out.println(props.getProperty("host"));
				System.out.println(props.getProperty("port"));	
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error loading file");
		}
	}
	
	private void openConnection() {
		try {
			credential = MongoCredential.createScramSha1Credential(props.getProperty("username"), props.getProperty("database"), props.getProperty("password").toCharArray());
			mongoClient = new MongoClient(new ServerAddress( props.getProperty("host"), Integer.parseInt(props.getProperty("port")) ), Arrays.asList(credential));
			database = mongoClient.getDatabase( props.getProperty("database") );
			collection = database.getCollection("users");	
			//Count documents in collection
			System.out.println(collection.count());
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid port");
		}
	}
	
	private void insertMongo() {
		//Insert
		/*Users user = new Users(1,"glennd","pass1234","Glenn","Dimaliwat");
		
		Document userObject = new  Document().append("_id", user.getId())
											  .append("username", user.getUsername())
											  .append("password", user.getPassword())
											  .append("firstName", user.getFirstName())
											  .append("lastName", user.getLastName());
		
		collection.insertOne(userObject);*/
	}
	

	private void deleteMongo() {
		//Delete
		/*collection.deleteOne(new Document().append("id", 1));		
		System.out.println(collection.count());*/
	}
	private void readMongo() {
		//Read
		//try (MongoCursor<Document> cursor = collection.find(new Document().append("firstName", "Glenn")).iterator() ) {
		try (MongoCursor<Document> cursor = collection.find(Filters.eq("firstName", "Glenn")).iterator() ) {
			while (cursor.hasNext()) {
		        System.out.println(cursor.next().toJson());
		    }
		}
	}
	private void updateMongo() {
		//Update
		/*Users user = new Users(1,"glennd","newpassword","Glenn","Dimaliwat");
		
		Document userObject = new Document().append("_id", user.getId())
											  .append("username", user.getUsername())
											  .append("password", user.getPassword())
											  .append("firstName", user.getFirstName())
											  .append("lastName", user.getLastName());
		
		collection.updateOne(Filters.eq("firstName","Glenn"), new Document("$set", userObject));
		*/
	}
		
	private void closeConnection() {
		mongoClient.close();
	}
	
	
	public static void main(String args[]) {
		
		ConnectToMongoDB ctm = new ConnectToMongoDB();
		
		//Load credentials from properties file
		ctm.initializeCredentials();
		ctm.openConnection();
		ctm.closeConnection();
	}
}
