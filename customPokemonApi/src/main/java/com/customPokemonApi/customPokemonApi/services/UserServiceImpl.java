package com.customPokemonApi.customPokemonApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.customPokemonApi.customPokemonApi.models.UserGeneralResponse;
import com.customPokemonApi.customPokemonApi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserGeneralResponse<String> login(String mail, String password) {
		String token = null;
		HttpStatus code;
		
		Boolean isCorrect = userRepository.isValidLogin(mail, password);
		if(isCorrect) {
			token = "Esto es un token ficticio";
			code = HttpStatus.OK;
		} else {
			code = HttpStatus.UNAUTHORIZED;
		}
		UserGeneralResponse<String> userGeneralResponse =  new UserGeneralResponse<String>(token, code);
		return userGeneralResponse;
	}

}
