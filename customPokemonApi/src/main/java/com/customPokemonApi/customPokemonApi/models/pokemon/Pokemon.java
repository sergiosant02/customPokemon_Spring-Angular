package com.customPokemonApi.customPokemonApi.models.pokemon;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Getter
public class Pokemon {

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", baseExperience=" + baseExperience + ", weight=" + weight
				+ ", height=" + height + ", photoSprites=" + photoSprites + ", abilities=" + abilities + ", stats="
				+ stats + "]";
	}

	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("base_experience")
	private Integer baseExperience;
	
	@JsonProperty("weight")
	private Integer weight;
	
	@JsonProperty("height")
	private Integer height;
	
	@OneToOne
	@JsonProperty("sprites")
	private PhotoSprites photoSprites;
	
	@OneToMany
	@JsonProperty("abilities")
	private List<Ability> abilities;
	
	@OneToMany
	@JsonProperty("stats")
	private List<Stat> stats;
	
	
	
}
