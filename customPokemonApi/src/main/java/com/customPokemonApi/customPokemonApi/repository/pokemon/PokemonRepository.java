package com.customPokemonApi.customPokemonApi.repository.pokemon;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

	public List<Pokemon> findAll();
	
	/*
	@Query("SELECT poke FROM Pokemon poke JOIN poke.photoSprites photo JOIN poke.abilities ab JOIN poke.stats stats JOIN stat.nameStat nameStat JOIN ab.abilityInfo abinfo")
	public List<Pokemon> findAllInfoAboutPokemons();
	*/
	
	@Query("SELECT poke FROM Pokemon poke WHERE poke.name=?1")
	public Optional<Pokemon> findByName(String name);
}
