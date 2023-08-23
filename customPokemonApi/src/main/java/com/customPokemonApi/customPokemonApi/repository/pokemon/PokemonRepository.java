package com.customPokemonApi.customPokemonApi.repository.pokemon;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

	public List<Pokemon> findAll();
	
	@Query("SELECT poke FROM Pokemon poke JOIN poke.photoSprites photo JOIN poke.abilities ab JOIN poke.stats stats JOIN stat.nameStat nameStat JOIN ab.abilityInfo abinfo")
	public List<Pokemon> findAllInfoAboutPokemons();
}
