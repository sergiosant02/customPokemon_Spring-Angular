package com.customPokemonApi.customPokemonApi.services;

import com.customPokemonApi.customPokemonApi.models.UserGeneralResponse;

public interface UserService {
	
	public UserGeneralResponse<String> login(String mail, String password);
	
}
