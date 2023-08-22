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
	@GeneratedValue(strategy = GenerationType.AUTO)
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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}
}
