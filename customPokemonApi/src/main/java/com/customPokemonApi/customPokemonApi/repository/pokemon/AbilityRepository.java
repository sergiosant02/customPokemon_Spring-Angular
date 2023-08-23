package com.customPokemonApi.customPokemonApi.repository.pokemon;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.Ability;
import com.customPokemonApi.customPokemonApi.models.pokemon.AbilityInfo;

@Repository
public interface AbilityRepository extends CrudRepository<Ability, Long> {

	@Query("SELECT ab FROM Ability ab WHERE ab.abilityInfo.name = :name")
	public Optional<Ability> getAbilityByAbilityInfoName(@Param("name") String name);
}
