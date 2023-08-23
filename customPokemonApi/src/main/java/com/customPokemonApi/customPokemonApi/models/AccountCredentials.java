package com.customPokemonApi.customPokemonApi.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCredentials {
	
	public AccountCredentials(String email, String password, String username)
	{
		super();
		this.email = email;
		this.password = password;
		this.username = username;
	}
	
	private String email;
	private String password;
	private String username;
	
}
