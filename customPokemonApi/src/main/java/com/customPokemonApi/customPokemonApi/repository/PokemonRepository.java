package com.customPokemonApi.customPokemonApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long>{

}
