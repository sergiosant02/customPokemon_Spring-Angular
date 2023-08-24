package com.customPokemonApi.customPokemonApi.repository.pokemon;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.pokemon.PhotoSprites;

@Repository
public interface PhotoSpritesRepository extends CrudRepository<PhotoSprites, Long> {
	@Query("SELECT ph FROM PhotoSprites ph WHERE (ph.backDefault = :backDefault or :backDefault IS NULL) and (ph.backFemale = :backFemale or :backFemale IS NULL) and (ph.backShiny = :backShiny or :backShiny IS NULL) and "
			+ "(ph.backShinyFemale = :backShinyFemale or :backShinyFemale IS NULL) and (ph.frontDefault = :frontDefault or :frontDefault IS NULL) and (ph.frontFemale = :frontFemale or :frontFemale IS NULL) and (ph.frontShiny = :frontShiny or :frontShiny IS NULL) "
			+ "and (ph.frontShinyFemale = :frontShinyFemale or :frontShinyFemale IS NULL)")
	public Optional<PhotoSprites> getPhotoSpritesByLink(@Param("backDefault") String backDefault, @Param("backFemale") String backFemale, @Param("backShiny") String backShiny,
			@Param("backShinyFemale") String backShinyFemale, @Param("frontDefault") String frontDefault, @Param("frontFemale") String frontFemale, @Param("frontShiny") String frontShiny,
			@Param("frontShinyFemale") String frontShinyFemale);
	

}
