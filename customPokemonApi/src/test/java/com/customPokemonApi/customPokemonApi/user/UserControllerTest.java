package com.customPokemonApi.customPokemonApi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.customPokemonApi.customPokemonApi.controllers.UserController;
import com.customPokemonApi.customPokemonApi.services.user.UserDetailsServiceImpl;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserDetailsServiceImpl service;
	
	
	
}
