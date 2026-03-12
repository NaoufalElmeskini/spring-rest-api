package io.lacrobate.spring_rest_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@Tag(name = "Status", description = "Health check")
public class HealthCheckController {

	@GetMapping
	@Operation(
		summary = "Health check",
		responses = @ApiResponse(responseCode = "200", description = "Service is up — returns HTTP 202 Accepted")
	)
	public HttpStatus status() {
		return HttpStatus.ACCEPTED;
	}
}
