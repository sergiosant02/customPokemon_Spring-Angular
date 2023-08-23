package com.customPokemonApi.customPokemonApi.models.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Stat")
@Getter
@Setter
public class Stat {
	
	@Override
	public String toString() {
		return "Stat [id=" + id + ", baseStat=" + baseStat + ", nameStat=" + nameStat + "]";
	}

	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@JsonProperty("base_stat")
	private Integer baseStat;
	
	@ManyToOne
	@JsonProperty("stat")
	private NameStat nameStat;
}
