package io.lacrobate.spring_rest_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
	private List<String> users = List.of("John", "Aicha");


	@GetMapping("/all")
	public String users() {
		return users.toString();
	}
}
