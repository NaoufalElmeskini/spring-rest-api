package io.lacrobate.spring_rest_api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
	private List<String> users = new ArrayList<>();
	{
		users.add("John");
		users.add("Aicha");
	}


	@GetMapping
	public String allUsers() {
		return users.toString();
	}

	@GetMapping("/exists/{user}")
	public Boolean doTheyExist(@PathVariable String user) {
		return users.contains(user);
	}

	@PostMapping
	public String addUser(@RequestBody String user) {
		users.add(user);
		return users.toString();
	}

}
