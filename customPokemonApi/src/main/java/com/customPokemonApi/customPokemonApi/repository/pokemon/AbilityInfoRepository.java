package com.customPokemonApi.customPokemonApi.repository.pokemon;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.Ability;
import com.customPokemonApi.customPokemonApi.models.pokemon.AbilityInfo;

@Repository
public interface AbilityInfoRepository extends CrudRepository<AbilityInfo, Long> {
	@Query("SELECT abInf FROM AbilityInfo abInf WHERE abInf.name = :name")
	public Optional<AbilityInfo> findAbilityByAbilityInfoName(@Param("name") String name);
}
