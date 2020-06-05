package com.hackathon.terminators;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.hackathon.terminators.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = { "com.hackathon.terminators" }) // same
																			// as
																			// @Configuration
																			// @EnableAutoConfiguration
																			// @ComponentScan
public class COVID19QualityCheck {

	public static void main(String[] args) {
		SpringApplication.run(COVID19QualityCheck.class, args);
	}
}
