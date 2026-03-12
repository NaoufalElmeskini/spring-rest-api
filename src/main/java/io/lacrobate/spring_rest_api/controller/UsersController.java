package io.lacrobate.spring_rest_api.controller;

import io.lacrobate.spring_rest_api.client.ExternalUser;
import io.lacrobate.spring_rest_api.client.JsonPlaceholderClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Manage the user list")
public class UsersController {
	private List<String> users = new ArrayList<>();
	{
		users.add("John");
		users.add("Aicha");
	}

	private final JsonPlaceholderClient jsonPlaceholderClient;

	public UsersController(JsonPlaceholderClient jsonPlaceholderClient) {
		this.jsonPlaceholderClient = jsonPlaceholderClient;
	}

	@GetMapping
	@Operation(
		summary = "List all users",
		responses = @ApiResponse(responseCode = "200", description = "Array of user names")
	)
		public String allUsers() {
		return users.toString();
	}

	@GetMapping("/external")
	@Operation(
		summary = "List users from JSONPlaceholder",
		description = "Calls the external JSONPlaceholder API and returns its 10 users",
		responses = @ApiResponse(responseCode = "200", description = "Array of external users (id, name, email)")
	)
	public List<ExternalUser> externalUsers() {
		return jsonPlaceholderClient.getUsers();
	}

	@GetMapping("/exists/{user}")
	@Operation(
		summary = "Check if a user exists",
		parameters = @Parameter(name = "user", description = "Name to look up", example = "Aicha"),
		responses = {
			@ApiResponse(responseCode = "200", description = "true if found, false otherwise")
		}
	)
	public Boolean doTheyExist(@PathVariable String user) {
		return users.contains(user);
	}

	@PostMapping
	@Operation(
		summary = "Add a new user",
		requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "Plain name of the user to add",
			content = @Content(examples = @ExampleObject(value = "Pierre"))
		),
		responses = @ApiResponse(responseCode = "200", description = "Updated list of users")
	)
	public String addUser(@RequestBody String user) {
		users.add(user);
		return users.toString();
	}

}
