package org.company.config;

import org.company.Animal;
import org.company.AnimalSound;
import org.company.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:config2.xml")
public class JavaConfig {
	
	@Bean
	public AnimalSound animalSound(Animal animal) {
		return new AnimalSound(animal);
	}
}
