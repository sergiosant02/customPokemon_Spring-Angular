package com.customPokemonApi.customPokemonApi.models.pokemon;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Namestat")
@Getter
@Setter
public class NameStat {

	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@JsonProperty("name")
	@Column(unique = true)
	private String name;

	@Override
	public String toString() {
		return "NameStat [id=" + id + ", name=" + name + "]";
	}
	
}
