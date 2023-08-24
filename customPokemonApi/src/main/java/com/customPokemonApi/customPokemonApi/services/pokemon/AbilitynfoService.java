package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;


import com.customPokemonApi.customPokemonApi.models.pokemon.AbilityInfo;

public interface AbilitynfoService {
	public Optional<AbilityInfo> getAbilityInfoByName(String name);
	public AbilityInfo save(AbilityInfo abilityInfo);
	public AbilityInfo manageAbilityInfo(AbilityInfo abilityInfo);
}
