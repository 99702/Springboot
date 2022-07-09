package com.auth.auth;

import com.auth.auth.domain.Role;
import com.auth.auth.domain.User;
import com.auth.auth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class AuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

//	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {

			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Sukhdev", "thakur", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "will", "will", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "milli", "milli", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "ronnie", "coleman", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "jay", "cutler", "1234", new ArrayList<>()));

			userService.addRoleToUser("thakur", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("will", "ROLE_USER");
			userService.addRoleToUser("milli", "ROLE_MANAGER");
			userService.addRoleToUser("coleman", "ROLE_ADMIN");
			userService.addRoleToUser("cutler", "ROLE_SUPER_ADMIN");


		};
	}
}
