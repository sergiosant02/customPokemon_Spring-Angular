package com.customPokemonApi.customPokemonApi.models.rolePack;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "role")
@Getter
@Setter
public class Role {
	
	

	@Override
	public String toString() {
		return "Role [name=" + name + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private ERole name;
	
	
	public Role() {
		
	}
	
	public Role(ERole erole) {
		this.name = erole;
	}
	

}
