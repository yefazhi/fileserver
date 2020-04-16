package com.qianlicode.document.dfscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.qianlicode.document.dfscore")
public class DfsCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DfsCoreApplication.class, args);
	}

}
