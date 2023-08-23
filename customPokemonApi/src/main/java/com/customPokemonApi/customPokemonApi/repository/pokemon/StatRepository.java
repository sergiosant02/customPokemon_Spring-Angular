package com.customPokemonApi.customPokemonApi.repository.pokemon;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.Stat;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {
	@Query("SELECT st FROM Stat st WHERE st.nameStat.name = :name")
	public Optional<Stat> getStatByStatName(@Param("name") String name);

}
