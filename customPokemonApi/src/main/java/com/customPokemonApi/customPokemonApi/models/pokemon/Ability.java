package com.customPokemonApi.customPokemonApi.models.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "Ability")
@Getter
@Setter
public class Ability {
	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@JsonProperty("slot")
	private Integer slot;
	
	@JsonProperty("is_hidden")
	private Boolean isHidden;
	
	@ManyToOne
	@JsonProperty("ability")
	private AbilityInfo abilityInfo;


	@Override
	public String toString() {
		return "Ability [id=" + id + ", slot=" + slot + ", isHidden=" + isHidden + ", abilityInfo=" + abilityInfo + "]";
	}
}
