package com.cognizant.claimManagement.InsuranceCompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cognizant.*")
@EnableJpaRepositories(basePackages = "com.cognizant.claimManagement.InsuranceCompany.repo") 
//Annotation to enable JPA repositories. Will scan the package of the annotated configuration class for Spring Datarepositories by default.
@EntityScan(basePackages = "com.cognizant.claimManagement.InsuranceCompany.entity")
/**
 * @Author Noimik 
 * BootStrap class
 * //Indicates a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning.
	//SPRINGBOOTAPPLICATION=((@EnableAutoConfiguration + @ComponentScan + @Configuration))
 */
public class InsuranceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceCompanyApplication.class, args);
		
		
	}

}
