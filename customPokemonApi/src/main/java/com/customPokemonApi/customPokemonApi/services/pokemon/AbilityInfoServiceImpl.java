package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customPokemonApi.customPokemonApi.models.pokemon.AbilityInfo;
import com.customPokemonApi.customPokemonApi.repository.pokemon.AbilityInfoRepository;

@Service
public class AbilityInfoServiceImpl implements AbilitynfoService {

	@Autowired
	private AbilityInfoRepository abilityInfoRepository;
	
	@Override
	public Optional<AbilityInfo> getAbilityInfoByName(String name) {
		return abilityInfoRepository.findAbilityByAbilityInfoName(name);
	}

	@Override
	public AbilityInfo save(AbilityInfo abilityInfo) {
		return abilityInfoRepository.save(abilityInfo);
	}

	@Override
	public AbilityInfo manageAbilityInfo(AbilityInfo abilityInfo) {
		AbilityInfo res;
		Optional<AbilityInfo> ab = this.getAbilityInfoByName(abilityInfo.getName());
		if(ab.isPresent()) {
			res = ab.get();
		} else {
			res = this.save(abilityInfo);
		}
		return res;
	}

}
