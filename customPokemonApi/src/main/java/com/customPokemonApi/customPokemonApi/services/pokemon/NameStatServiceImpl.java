package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customPokemonApi.customPokemonApi.models.pokemon.NameStat;
import com.customPokemonApi.customPokemonApi.repository.pokemon.NameStatRepository;

@Service
public class NameStatServiceImpl implements NameStatService {

	@Autowired
	private NameStatRepository nameStatRepository;
	
	@Override
	public Optional<NameStat> getNameStatByName(String name) {
		return nameStatRepository.findNameStatByName(name);
	}

	@Override
	public NameStat save(NameStat nameStat) {
		return nameStatRepository.save(nameStat);
	}

	@Override
	public NameStat manageNameStat(NameStat nameStat) {
		NameStat res;
		Optional<NameStat> nS = this.getNameStatByName(nameStat.getName());
		if(nS.isPresent()) {
			res = nS.get();
		} else {
			res = this.save(nameStat);
			
		}
		return res;
	}

}
