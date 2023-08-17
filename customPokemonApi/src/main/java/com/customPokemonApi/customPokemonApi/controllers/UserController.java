package com.customPokemonApi.customPokemonApi.controllers;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customPokemonApi.customPokemonApi.models.UserGeneralResponse;
import com.customPokemonApi.customPokemonApi.services.UserService;

@RestController
@RequestMapping(
        value="/api/v1/user",
        consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE, ALL_VALUE},
        produces = {APPLICATION_JSON_VALUE})
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping(value="/login")
	public ResponseEntity<UserGeneralResponse<String>> login(@RequestBody()String mail, @RequestBody String password ){
		ResponseEntity<UserGeneralResponse<String>> response;
		UserGeneralResponse<String> userResponse = userService.login(mail, password);
		response = new ResponseEntity<UserGeneralResponse<String>>(userResponse, userResponse.getHttpStatus());
		return response;
	}
}
