package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import com.customPokemonApi.customPokemonApi.models.pokemon.Ability;

public interface AbilityService {
	public Optional<Ability> getAbilityByAbilityInfoName(Ability ability);
	public Ability save(Ability ability);
	public Ability manageAbility(Ability ability);
}
