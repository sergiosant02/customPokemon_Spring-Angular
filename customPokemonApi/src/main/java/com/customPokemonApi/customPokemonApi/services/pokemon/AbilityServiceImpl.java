package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customPokemonApi.customPokemonApi.models.pokemon.Ability;
import com.customPokemonApi.customPokemonApi.repository.pokemon.AbilityRepository;

@Service
public class AbilityServiceImpl implements AbilityService{
	
	@Autowired
	private AbilityRepository abilityRepository;
	
	
	@Override
	public Optional<Ability> getAbilityByAbilityInfoName(String name) {
		Optional<Ability> ab=abilityRepository.getAbilityByAbilityInfoName(name);
		return ab;
	}

}
