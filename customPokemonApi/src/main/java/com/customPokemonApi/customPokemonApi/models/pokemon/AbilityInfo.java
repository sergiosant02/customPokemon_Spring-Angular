package com.customPokemonApi.customPokemonApi.models.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "AbilityInfo")
@Getter
@Setter
public class AbilityInfo {
	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@JsonProperty("name")
	@Column(unique = true)
	private String name;

	public String getName() {
		return name.replaceAll("-", " ");
	}

	@Override
	public String toString() {
		return "AbilityInfo [id=" + id + ", name=" + name + "]";
	}
	
}
