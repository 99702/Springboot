package com.example.annotation;

import mypack.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication

/*
@SpringBootApplication equivalent to
                       @EnableAutoConfiguration  : Helps `spring-boot-starter-web` related things autoconfigure
                       @ComponentScan:
                       @Configuration

@Autowired
           - can be done in property, setter, constructor , class or method must be bean

@Component
           - Instead of writing @Bean to methods, we can just use @Component that automatically find beans

           @Controller - MVC controller
           @Service - business logic
           @Repository - provide dao facilities

@ComponentScan - finds component outside the base package.

@Bean - when there are two or more methods of same class like in `MyConfig` , which have two methods of same return type Student class.
      -  so we can use qualifier for example
      - @Bean("student1")  and @Bean("student2")   *and* when injecting or making object of that bean in @Autowired ,
      - we should put @Qualifier(name) i.e Qualifier("student1") or @Qualifier("student2")
 */
public class AnnotationApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("getStudent")
	private Student student;

	@Autowired
	private Date date;

	@Autowired
	private Emp emp;

	@Autowired
	private Dog dog;

	@Override
	public void run(String... args) throws Exception {
//		this.student.studying();
		this.emp.whatsYourName();
		this.dog.eating();
	}


	public static void main(String[] args) {
		SpringApplication.run(AnnotationApplication.class, args);
	}

}
