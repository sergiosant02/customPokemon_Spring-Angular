package com.customPokemonApi.customPokemonApi.repository.pokemon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.NameStat;

@Repository
public interface NameStatRepository extends CrudRepository<NameStat, Long> {

}
