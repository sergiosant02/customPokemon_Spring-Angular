package com.customPokemonApi.customPokemonApi.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.customPokemonApi.customPokemonApi.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public String login(String mail, String password) {
		String token = null;
		Boolean isCorrect = userRepository.isValidLogin(mail, password);
		if(isCorrect) token = "Esto es un token ficticio";
		return token;
	}

}
