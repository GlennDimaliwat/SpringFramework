package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//Fortune data from properties file
	/*@Value("${foo.fortune}")
	private String allFortuneTexts;*/
	
	@Override
	public String getFortune() {
				
		/*String[] data = {"You are very lucky",
						 "You are a but lucky",
						 "You are not lucky"};*/
		//String[] data = allFortuneTexts.split("\\;");
		//Get data from File instead of properties file
		String[] data = getAllFortuneTextsFromFile().split("\\\n");
		
		Random random = new Random();
		
		System.out.println("Data.length: " + data.length);
		int index = random.nextInt(data.length);
		
		return data[index];
	}
	
	/*public String getAllFortuneTexts() {
		return allFortuneTexts;
	}*/
	
	public String getAllFortuneTextsFromFile() {
		String allFortuneStr = "";
		String fileName = "src/fortune.txt";
		File theFile = new File(fileName);
		
		try (BufferedReader br = new BufferedReader(
									new FileReader(theFile))) {
			String strLine;
			while( (strLine = br.readLine())!=null ) {
				allFortuneStr += strLine + "\n";
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return allFortuneStr;
	}

	// Define my init method
	@PostConstruct
	public void initFortuneStuff() {
		System.out.println("RandomFortuneService: inside initFortuneStuff()");
	}
	
	// Define my destroy method
	@PreDestroy
	public void destroyFortuneStuff() {
		System.out.println("RandomFortuneService: inside destroyFortuneStuff()");
	}
}
