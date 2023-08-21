package com.customPokemonApi.customPokemonApi.models;


public class AccountCredentials {
	
	public AccountCredentials(String mail, String password, String username)
	{
		super();
		this.mail = mail;
		this.password = password;
		this.username = username;
	}
	
	private String mail;
	private String password;
	private String username;
	
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
