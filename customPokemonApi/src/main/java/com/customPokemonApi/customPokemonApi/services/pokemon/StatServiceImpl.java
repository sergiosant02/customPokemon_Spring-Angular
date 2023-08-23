package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customPokemonApi.customPokemonApi.models.pokemon.Ability;
import com.customPokemonApi.customPokemonApi.models.pokemon.Stat;
import com.customPokemonApi.customPokemonApi.repository.pokemon.StatRepository;

@Service
public class StatServiceImpl implements StatService{

	@Autowired
	private StatRepository statRepository;
	
	
	@Override
	public Optional<Stat> getStatByStatName(String name) {
		Optional<Stat> st=statRepository.getStatByStatName(name);
		return st;
	}
	
	@Override
	public Stat manageState(Stat stat) {
		Stat res;
		Optional<Stat> st = this.getStatByStatName(stat.getNameStat().getName());
		if(st.isPresent()) {
			res = st.get();
		} else {
			res = this.save(stat);
		}
		return res;
		
	}

	@Override
	public Stat save(Stat stat) {
		
		return statRepository.save(stat);
	}

}
