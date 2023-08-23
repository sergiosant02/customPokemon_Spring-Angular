package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.List;
import java.util.Objects;

import org.eclipse.collections.impl.list.mutable.FastList;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.customPokemonApi.customPokemonApi.models.PokemonGeneralResponse;
import com.customPokemonApi.customPokemonApi.models.pokemon.Pokemon;
import com.customPokemonApi.customPokemonApi.repository.PokemonRepository;
import com.customPokemonApi.customPokemonApi.repository.pokemon.AbilityInfoRepository;
import com.customPokemonApi.customPokemonApi.repository.pokemon.AbilityRepository;
import com.customPokemonApi.customPokemonApi.repository.pokemon.NameStatRepository;
import com.customPokemonApi.customPokemonApi.repository.pokemon.PhotoSpritesRepository;
import com.customPokemonApi.customPokemonApi.repository.pokemon.StatRepository;

@Service
public class PokemonServiceImpl implements PokemonService{

	private RestTemplate pokemonApiRestTemplate;
	private HttpHeaders httpHeaders;

	private PokemonRepository pokemonRepository;
	private AbilityRepository abilityRepository;
	private AbilityInfoRepository abilityInfoRepository;
	private NameStatRepository nameStatRepository;
	private StatRepository statRepository;
	private PhotoSpritesRepository photoSpritesRepository;

	public PokemonServiceImpl(PokemonRepository pokemonRepository, @Qualifier("PokemonApiTemplate") RestTemplate pokemonApiRestTemplate,AbilityRepository abilityRepository, AbilityInfoRepository abilityInfoRepository,
			NameStatRepository nameStatRepository, StatRepository statRepository,
			PhotoSpritesRepository photoSpritesRepository){
		this.pokemonApiRestTemplate = pokemonApiRestTemplate;
		this.httpHeaders = new HttpHeaders();;
		
		this.pokemonRepository = pokemonRepository;
		this.abilityRepository = abilityRepository;
		this.abilityInfoRepository = abilityInfoRepository;
		this.nameStatRepository = nameStatRepository;
		this.statRepository = statRepository;
		this.photoSpritesRepository = photoSpritesRepository;
	}

	@Override
	public PokemonGeneralResponse<Pokemon> getPokemonByIdNetwork(Integer id) {
		String path = String.format("/%d", id);
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath(path);
		PokemonGeneralResponse<Pokemon> res;
		Pokemon poke;

		ResponseEntity<Pokemon> response = pokemonApiRestTemplate
				.exchange(builder.build().toString(), HttpMethod.GET, new HttpEntity<>(httpHeaders), new ParameterizedTypeReference<Pokemon>() {});
		if (response.getStatusCode() == HttpStatus.OK) {
			poke = Objects.requireNonNull(response.getBody());
			poke.getAbilities().forEach(
					ab -> {
						ab.setAbilityInfo(abilityInfoRepository.save( ab.getAbilityInfo() ) );
						ab = abilityRepository.save(ab);
					}
					);
			
			poke.getStats().forEach(
					stat -> {
						stat.setNameStat(nameStatRepository.save(stat.getNameStat()));
						stat = statRepository.save(stat);
					}
					);
			poke.setPhotoSprites(photoSpritesRepository.save(poke.getPhotoSprites()));
			pokemonRepository.save(poke);
			
		} else {
			throw new IllegalArgumentException("Error: Issue retrieving pokemon.");
		}
		
		return null;
	}

	//Hay un maximo de 1010 ids
	@Scheduled(fixedRate = 604800016) //Vuelve a popular la Bd cada dos semanas, para garantizar un minimo de actualidad.
	@Override
	public void populateBdPokemon() {


	}

	@Override
	public PokemonGeneralResponse<List<Pokemon>> getPokemonList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PokemonGeneralResponse<List<Pokemon>> inceasePokemonListData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PokemonGeneralResponse<Pokemon> getPokemonById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PokemonGeneralResponse<Pokemon> getPokemonByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}



}
