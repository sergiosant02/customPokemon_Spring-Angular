package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import com.customPokemonApi.customPokemonApi.models.pokemon.Ability;
import com.customPokemonApi.customPokemonApi.models.pokemon.Stat;

public interface StatService {
	public Optional<Stat> getStatByStatName(String name, Integer baseStat);
	public Stat manageState(Stat stat);
	public Stat save(Stat stat);
}
