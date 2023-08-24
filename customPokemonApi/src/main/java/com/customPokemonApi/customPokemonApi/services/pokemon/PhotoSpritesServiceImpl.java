package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customPokemonApi.customPokemonApi.models.pokemon.PhotoSprites;
import com.customPokemonApi.customPokemonApi.repository.pokemon.PhotoSpritesRepository;


@Service
public class PhotoSpritesServiceImpl implements PhotoSpritesService{

	@Autowired
	private PhotoSpritesRepository phRepository;
	
	
	
	
	@Override
	public Optional<PhotoSprites> getPhotoSpritesByLink(String backDefault,String backFemale, String backShiny, String backShinyFemale, String frontDefault,  String frontFemale, 
			String frontShiny, String frontShinyFemale) {
		Optional<PhotoSprites> ph=phRepository.getPhotoSpritesByLink(backDefault, backFemale, backShiny, backShinyFemale, frontDefault, frontFemale, frontShiny, frontShinyFemale);
		return ph;
	}
	
	@Override
	public PhotoSprites managePhotoSprites(PhotoSprites photo) {
		PhotoSprites res;
		Optional<PhotoSprites> ph = this.getPhotoSpritesByLink(photo.getBackDefault(), photo.getBackFemale(), photo.getBackShiny(), photo.getBackShinyFemale(), photo.getFrontDefault(),
				photo.getFrontFemale(), photo.getFrontShiny(), photo.getFrontShinyFemale());
		if(ph.isPresent()) {
			res = ph.get();
		} else {
			photo.setBackDefault(photo.getBackDefault());
			photo.setBackFemale(photo.getBackFemale());
			photo.setBackShiny(photo.getBackShiny());
			photo.setBackShinyFemale(photo.getBackShinyFemale());
			photo.setFrontDefault(photo.getFrontDefault());
			photo.setFrontFemale(photo.getFrontFemale());
			photo.setFrontShiny(photo.getFrontShiny());
			photo.setFrontShinyFemale(photo.getFrontShinyFemale());
			res = this.save(photo);
		}
		return res;
		
	}

	@Override
	public PhotoSprites save(PhotoSprites photo) {
		
		return phRepository.save(photo);
	}
}
