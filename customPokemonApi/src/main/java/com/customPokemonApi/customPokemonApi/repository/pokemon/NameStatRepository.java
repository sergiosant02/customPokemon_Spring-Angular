package com.customPokemonApi.customPokemonApi.repository.pokemon;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.NameStat;

@Repository
public interface NameStatRepository extends CrudRepository<NameStat, Long> {
	@Query("SELECT nS FROM NameStat nS WHERE nS.name = :name")
	public Optional<NameStat> findNameStatByName(@Param("name") String name);
}
