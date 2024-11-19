package io.lacrobate.spring_rest_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

	@GetMapping
	public HttpStatus status() {
		return HttpStatus.ACCEPTED;
	}
}