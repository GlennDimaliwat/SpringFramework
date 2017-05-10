package com.glenndimaliwat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.glenndimaliwat")  //-- Don't need this.. @SpringBootApplication already includes @Configuratopn, @EnableAutoConfiguraton and @ComponentScan on the same package
public class SpringCoreFundamentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreFundamentalsApplication.class, args);
	}
}
