package com.customPokemonApi.customPokemonApi.models.user;


import com.customPokemonApi.customPokemonApi.models.CreateAccountCredentials;
import com.customPokemonApi.customPokemonApi.models.rolePack.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "credentials")
public class UserModel {
	
	public UserModel() {
		
	}
	
	public UserModel(String name, String username, String lastName, String email, String password)
	{
		super();
		this.name = name;
		this.username = username;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public static UserModel byCredentials(CreateAccountCredentials credentials) {
		 UserModel user = new UserModel(credentials.getName(), credentials.getUsername(), credentials.getLastName(),
				 credentials.getEmail(),
	               credentials.getPassword());
		 return user;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@JoinColumn(nullable = false, name = "role_id")
	@ManyToOne
	private Role role;



}
