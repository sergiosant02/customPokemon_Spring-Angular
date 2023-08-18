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
import com.customPokemonApi.customPokemonApi.models.rolePack.ERole;
import com.customPokemonApi.customPokemonApi.models.rolePack.Role;
import com.customPokemonApi.customPokemonApi.models.user.UserDetailsImpl;
import com.customPokemonApi.customPokemonApi.models.user.UserGeneralResponse;
import com.customPokemonApi.customPokemonApi.models.user.UserModel;
import com.customPokemonApi.customPokemonApi.repository.RoleRepository;
import com.customPokemonApi.customPokemonApi.repository.UserRepository;
import com.customPokemonApi.customPokemonApi.services.UserService;

@RestController
@RequestMapping(
        value="/api/v1/user",
        consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE, ALL_VALUE},
        produces = {APPLICATION_JSON_VALUE})
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtils jwtUtils;
	  
	@Autowired
	private UserService userService;

	@PostMapping(value="/login")
	public ResponseEntity<UserGeneralResponse<String>> login(@RequestBody() AccountCredentials accountCredentials ){
		ResponseEntity<UserGeneralResponse<String>> response;
		UserGeneralResponse<String> userResponse = userService.login(accountCredentials.getMail(), accountCredentials.getPassword());
		response = new ResponseEntity<UserGeneralResponse<String>>(userResponse, userResponse.getHttpStatus());
		return response;
	}
	
	@GetMapping(value = "/get")
	public String prueba( ){
		
		return "Prueba";
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody AccountCredentials loginRequest) {

	String pass = encoder.encode("prueba");
	  Authentication authentication = authenticationManager.authenticate(
	      new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

	  SecurityContextHolder.getContext().setAuthentication(authentication);
	  String jwt = jwtUtils.generateJwtToken(authentication);
	  UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
	  List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok(new JwtResponse(jwt, 
	                         userDetails.getId(), 
	                         userDetails.getUsername(), 
	                         userDetails.getEmail(), 
	                         roles));
	  }
	
	@PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody CreateAccountCredentials signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return ResponseEntity
	          .badRequest()
	          .body("Error: Username is already taken!");
	    }

	    if (userRepository.existsByMail(signUpRequest.getMail())) {
	      return ResponseEntity
	          .badRequest()
	          .body("Error: Email is already in use!");
	    }

	    // Create new user's account
	    UserModel user = new UserModel(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getLastName(),
	               signUpRequest.getMail(),
	               encoder.encode(signUpRequest.getPassword()));

	    Role role = new Role(ERole.USER);
	    user.setRole(role);
	    userRepository.save(user);

	    return ResponseEntity.ok("User registered successfully!");
	  }
}
