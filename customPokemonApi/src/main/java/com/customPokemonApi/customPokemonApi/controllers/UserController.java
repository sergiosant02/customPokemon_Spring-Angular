package com.customPokemonApi.customPokemonApi.controllers;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.customPokemonApi.customPokemonApi.configs.jwt.JwtResponse;
import com.customPokemonApi.customPokemonApi.configs.jwt.JwtUtils;
import com.customPokemonApi.customPokemonApi.models.AccountCredentials;
import com.customPokemonApi.customPokemonApi.models.CreateAccountCredentials;
import com.customPokemonApi.customPokemonApi.models.pokemon.Pokemon;
import com.customPokemonApi.customPokemonApi.models.rolePack.ERole;
import com.customPokemonApi.customPokemonApi.models.user.UserDetailsImpl;
import com.customPokemonApi.customPokemonApi.models.user.UserModel;
import com.customPokemonApi.customPokemonApi.services.pokemon.PokemonServiceImpl;
import com.customPokemonApi.customPokemonApi.services.role.RoleServiceImpl;
import com.customPokemonApi.customPokemonApi.services.user.UserDetailsServiceImpl;

@RestController
@RequestMapping(
		value="/api/v1/user",
		consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE, ALL_VALUE},
		produces = {APPLICATION_JSON_VALUE})
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserDetailsServiceImpl userService;
	
	@Autowired
	private PokemonServiceImpl pokeService;
	
	@Autowired
	private PasswordEncoder encoder;


	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody AccountCredentials loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		pokeService.getPokemonByIdNetwork(1);
		return ResponseEntity.ok(new JwtResponse(jwt, 
				userDetails.getId(), 
				userDetails.getUsername(), 
				userDetails.getEmail(), 
				roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody CreateAccountCredentials signUpRequest) {
		UserModel user; 
		ResponseEntity<?> res;
		String oldPassword = signUpRequest.getPassword();
		if (userService.existsByUsername(signUpRequest.getUsername())) {
			res = ResponseEntity
					.badRequest()
					.body("Error: Username is already taken!");
		} else if (userService.existsByMail(signUpRequest.getEmail())) {
			res = ResponseEntity
					.badRequest()
					.body("Error: Email is already in use!");
		} else {
			
			// Create new user's account
			signUpRequest.setPassword(encoder.encode(signUpRequest.getPassword()));
			user = userService.createUserByCredentials(signUpRequest);
			if (user == null) {
				res = ResponseEntity
						.badRequest()
						.body("Error: Rol not found");
			}
			AccountCredentials accountCredentials = new AccountCredentials(signUpRequest.getEmail(), oldPassword, signUpRequest.getUsername());
			res = authenticateUser(accountCredentials);
		}

		return res;
	}
}
