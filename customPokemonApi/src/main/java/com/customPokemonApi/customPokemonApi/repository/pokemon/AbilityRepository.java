package com.customPokemonApi.customPokemonApi.repository.pokemon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.Ability;

@Repository
public interface AbilityRepository extends CrudRepository<Ability, Long> {

}
