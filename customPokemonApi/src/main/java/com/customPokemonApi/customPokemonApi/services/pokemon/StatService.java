package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import com.customPokemonApi.customPokemonApi.models.pokemon.Stat;

public interface StatService {
	public Optional<Stat> getStatByStatName(String name);
}
