package com.customPokemonApi.customPokemonApi.repository.pokemon;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.PhotoSprites;

@Repository
public interface PhotoSpritesRepository extends CrudRepository<PhotoSprites, Long> {
	@Query("SELECT ph FROM PhotoSprites ph WHERE ph.backDefault = :backDefault and ph.backFemale = :backFemale and ph.backShiny = :backShiny and"
			+ "ph.backShinyFemale = :backShinyFemale and ph.frontDefault = :frontDefault and ph.frontFemale = :frontFemale and ph.frontShiny = :frontShiny and ph.frontShinyFemale = :frontShinyFemale")
	public Optional<PhotoSprites> getPhotoSpritesByLink(@Param("backDefault") String backDefault, @Param("backFemale") String backFemale, @Param("backShiny") String backShiny,
			@Param("backShinyFemale") String backShinyFemale, @Param("frontDefault") String frontDefault, @Param("frontFemale") String frontFemale, @Param("frontShiny") String frontShiny,
			@Param("frontShinyFemale") String frontShinyFemale);
	

}
