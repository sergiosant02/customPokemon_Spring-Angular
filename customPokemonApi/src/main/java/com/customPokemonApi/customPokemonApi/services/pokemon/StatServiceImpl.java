package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
