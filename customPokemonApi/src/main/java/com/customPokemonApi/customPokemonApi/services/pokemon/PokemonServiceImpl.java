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

@Service
public class PokemonServiceImpl implements PokemonService{
	
	private PokemonRepository pokemonRepository;
    private RestTemplate pokemonApiRestTemplate;
    private HttpHeaders httpHeaders;
    
	public PokemonServiceImpl(PokemonRepository pokemonRepository, @Qualifier("PokemonApiTemplate") RestTemplate pokemonApiRestTemplate){
		this.pokemonRepository = pokemonRepository;
		this.pokemonApiRestTemplate = pokemonApiRestTemplate;
		this.httpHeaders = new HttpHeaders();;
	}
	
	@Override
	public PokemonGeneralResponse<Pokemon> getPokemonByIdNetwork(Integer id) {
		String path = String.format("/%d", id);
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath(path);
		
		
		ResponseEntity<Pokemon> response = pokemonApiRestTemplate
				.exchange(builder.build().toString(), HttpMethod.GET, new HttpEntity<>(httpHeaders), new ParameterizedTypeReference<Pokemon>() {});
		 if (response.getStatusCode() == HttpStatus.OK) {
	            System.out.println(Objects.requireNonNull(response.getBody()).toString());
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
