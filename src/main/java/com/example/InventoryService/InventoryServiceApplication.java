//SE_ASS6_Group65_i6297119_i6314833
//Group 65: Matei Turcan & Thu Vo

package com.example.InventoryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
