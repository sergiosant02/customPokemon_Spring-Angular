package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import com.customPokemonApi.customPokemonApi.models.pokemon.Ability;

public interface AbilityService {
	public Optional<Ability> getAbilityByAbilityInfoName(String name);
}
