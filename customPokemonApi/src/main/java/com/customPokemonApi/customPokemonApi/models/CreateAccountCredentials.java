package com.customPokemonApi.customPokemonApi.models;

public class CreateAccountCredentials {
	
	public CreateAccountCredentials(String email, String password, String username, String name, String lastName)
	{
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.name = name;
		this.lastName = lastName;
	}
	public CreateAccountCredentials(){}
	
	private String email;
	private String password;
	private String username;
	private String name;
	private String lastName;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
