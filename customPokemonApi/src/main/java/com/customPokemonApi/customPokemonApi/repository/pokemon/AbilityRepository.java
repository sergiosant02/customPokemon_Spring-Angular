package com.customPokemonApi.customPokemonApi.repository.pokemon;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.Ability;

@Repository
public interface AbilityRepository extends CrudRepository<Ability, Long> {

	@Query("SELECT ab FROM Ability ab WHERE ab.abilityInfo.name = :name AND ab.slot = :slot AND ab.isHidden = :isHidden")
	public Optional<Ability> findAbilityByAbilityInfoName(@Param("name") String name, @Param("slot") Integer slot, @Param("isHidden") Boolean isHidden);
}
