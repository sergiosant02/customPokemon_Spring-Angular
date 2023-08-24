package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
import com.customPokemonApi.customPokemonApi.models.pokemon.Ability;
import com.customPokemonApi.customPokemonApi.models.pokemon.Pokemon;
import com.customPokemonApi.customPokemonApi.models.pokemon.Stat;
import com.customPokemonApi.customPokemonApi.repository.pokemon.AbilityInfoRepository;
import com.customPokemonApi.customPokemonApi.repository.pokemon.AbilityRepository;
import com.customPokemonApi.customPokemonApi.repository.pokemon.NameStatRepository;
import com.customPokemonApi.customPokemonApi.repository.pokemon.PhotoSpritesRepository;
import com.customPokemonApi.customPokemonApi.repository.pokemon.PokemonRepository;
import com.customPokemonApi.customPokemonApi.repository.pokemon.StatRepository;
import com.customPokemonApi.customPokemonApi.utils.Utils;

@Service
public class PokemonServiceImpl implements PokemonService{

	private RestTemplate pokemonApiRestTemplate;
	private HttpHeaders httpHeaders;

	private PokemonRepository pokemonRepository;
	private AbilityServiceImpl abilityService;
	private StatServiceImpl statService;
	private PhotoSpritesRepository photoSpritesRepository;

	public PokemonServiceImpl(PokemonRepository pokemonRepository, @Qualifier("PokemonApiTemplate") RestTemplate pokemonApiRestTemplate,AbilityServiceImpl abilityService, AbilityInfoRepository abilityInfoRepository,
			StatServiceImpl statService,
			PhotoSpritesRepository photoSpritesRepository){
		this.pokemonApiRestTemplate = pokemonApiRestTemplate;
		this.httpHeaders = new HttpHeaders();;
		
		this.pokemonRepository = pokemonRepository;
		this.abilityService = abilityService;
		this.statService = statService;
		this.photoSpritesRepository = photoSpritesRepository;
	}

	@Override
	public Pokemon getPokemonByIdNetwork(Long id) {
		String path = String.format("/%d", id);
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath(path);
		PokemonGeneralResponse<Pokemon> res;
		Pokemon poke;

		ResponseEntity<Pokemon> response = pokemonApiRestTemplate
				.exchange(builder.build().toString(), HttpMethod.GET, new HttpEntity<>(httpHeaders), new ParameterizedTypeReference<Pokemon>() {});
		if (response.getStatusCode() == HttpStatus.OK) {
			poke = Objects.requireNonNull(response.getBody());
			poke = this.save(poke);
			
		} else {
			throw new IllegalArgumentException("Error: Issue retrieving pokemon.");
		}
		
		return poke;
	}
	
	@Override
	public Pokemon getPokemonByNameNetwork(String name) {
		String path = String.format("/%s", name);
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath(path);
		Pokemon poke;

		ResponseEntity<Pokemon> response = pokemonApiRestTemplate
				.exchange(builder.build().toString(), HttpMethod.GET, new HttpEntity<>(httpHeaders), new ParameterizedTypeReference<Pokemon>() {});
		if (response.getStatusCode() == HttpStatus.OK) {
			poke = Objects.requireNonNull(response.getBody());
			poke = save(poke);
			
		} else {
			throw new IllegalArgumentException("Error: Issue retrieving pokemon.");
		}
		
		return poke;
	}

	//Hay un maximo de 1010 ids
	@Scheduled(fixedRate = 604800016) //Vuelve a popular la Bd cada dos semanas, para garantizar un minimo de actualidad. 604800016 ms
	@Override
	public void populateBdPokemon() {
		if(getPokemonList().size() < 100) {
			for(int i = 1; i <= 100; i++) {
				this.getPokemonByIdNetwork((long) i);
			}
		}
		

	}

	@Override
	public List<Pokemon> getPokemonList() {
		
		return pokemonRepository.findAll();
	}
	
	@Override
	public PokemonGeneralResponse<List<Pokemon>> getPokemonListResponse() {
		// TODO Auto-generated method stub
		return new PokemonGeneralResponse<List<Pokemon>>(this.getPokemonList(), HttpStatus.OK);
	}

	@Override
	public PokemonGeneralResponse<List<Pokemon>> increasePokemonListData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PokemonGeneralResponse<Pokemon> getPokemonById(Long id) {
		PokemonGeneralResponse<Pokemon> res;
		Optional<Pokemon> poke = pokemonRepository.findById(id);
		res = new PokemonGeneralResponse<Pokemon>(poke.orElse(null), Utils.getHttpCodeOptional(poke));
		if(res.getHttpStatus().is4xxClientError()) {
			Pokemon newPoke = this.getPokemonByIdNetwork(id); 
			res = new PokemonGeneralResponse<Pokemon>(newPoke, HttpStatus.OK);
		}
		return res;
	}

	@Override
	public PokemonGeneralResponse<Pokemon> getPokemonByName(String name) {
		PokemonGeneralResponse<Pokemon> res;
		Optional<Pokemon> poke = pokemonRepository.findByName(name);
		res = new PokemonGeneralResponse<Pokemon>(poke.orElse(null), Utils.getHttpCodeOptional(poke));
		return res;
	}

	@Override
	public Pokemon save(Pokemon pokemon) {
		List<Ability> abList = pokemon.getAbilities().stream().map(
				ab -> 
					
					ab = abilityService.manageAbility(ab)
				
				).toList();
		
		List<Stat> stList = pokemon.getStats().stream().map(
				stat -> 
					
					stat = statService.manageState(stat)
				
				).toList();
		pokemon.setAbilities(abList);
		pokemon.setStats(stList);
		pokemon.setPhotoSprites(photoSpritesRepository.save(pokemon.getPhotoSprites()));
		
		return pokemonRepository.save(pokemon);
	}

	



}
