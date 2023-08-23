package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customPokemonApi.customPokemonApi.models.pokemon.Ability;
import com.customPokemonApi.customPokemonApi.repository.pokemon.AbilityInfoRepository;
import com.customPokemonApi.customPokemonApi.repository.pokemon.AbilityRepository;

@Service
public class AbilityServiceImpl implements AbilityService{
	
	@Autowired
	private AbilityRepository abilityRepository;
	@Autowired
	private AbilityInfoRepository abilityInfoRepository;
	
	
	
	@Override
	public Optional<Ability> getAbilityByAbilityInfoName(String name) {
		Optional<Ability> ab=abilityRepository.getAbilityByAbilityInfoName(name);
		return ab;
	}
	
	@Override
	public Ability manageAbility(Ability ability) {
		Ability res;
		Optional<Ability> ab = this.getAbilityByAbilityInfoName(ability.getAbilityInfo().getName());
		if(ab.isPresent()) {
			res = ab.get();
		} else {
			ability.setAbilityInfo(abilityInfoRepository.save(ability.getAbilityInfo()));
			res = this.save(ability);
			
		}
		System.out.println(res);
		return res;
		
	}

	@Override
	public Ability save(Ability ability) {
		
		return abilityRepository.save(ability);
	}

}
