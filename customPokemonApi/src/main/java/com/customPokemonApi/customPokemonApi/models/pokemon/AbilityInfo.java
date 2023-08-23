package com.customPokemonApi.customPokemonApi.models.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "AbilityInfo")
public class AbilityInfo {
	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@JsonProperty("name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name.replaceAll("-", " ");
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AbilityInfo [id=" + id + ", name=" + name + "]";
	}
	
}
