package org.company.config;

import org.company.Animal;
import org.company.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig2 {
	
	@Bean
	public Animal animal() {
		return new Cat();
	}
}
