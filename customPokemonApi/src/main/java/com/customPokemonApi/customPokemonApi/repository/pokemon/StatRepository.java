package com.customPokemonApi.customPokemonApi.repository.pokemon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.Stat;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {

}
