package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;


import com.customPokemonApi.customPokemonApi.models.pokemon.PhotoSprites;

public interface PhotoSpritesService {
	public Optional<PhotoSprites> getPhotoSpritesByLink(String backDefault,String backFemale, String backShiny, String backShinyFemale, String frontDefault,  String frontFemale, 
			String frontShiny, String frontShinyFemale);

	public PhotoSprites managePhotoSprites(PhotoSprites photo);

	public PhotoSprites save(PhotoSprites photo);
}
