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
	private AbilityInfoServiceImpl abilityInfoService;
	
	
	
	@Override
	public Optional<Ability> getAbilityByAbilityInfoName(Ability ability) {
		Optional<Ability> ab=abilityRepository.findAbilityByAbilityInfoName(ability.getAbilityInfo().getName(), ability.getSlot(), ability.getIsHidden());
		return ab;
	}
	
	@Override
	public Ability manageAbility(Ability ability) {
		Ability res;
		Optional<Ability> ab = this.getAbilityByAbilityInfoName(ability);
		if(ab.isPresent()) {
			res = ab.get();
		} else {
			ability.setAbilityInfo(abilityInfoService.manageAbilityInfo(ability.getAbilityInfo()));
			res = this.save(ability);
			
		}
		return res;
		
	}

	@Override
	public Ability save(Ability ability) {
		
		return abilityRepository.save(ability);
	}

}
