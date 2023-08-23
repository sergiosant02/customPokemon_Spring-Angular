package com.customPokemonApi.customPokemonApi.controllers;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customPokemonApi.customPokemonApi.models.PokemonGeneralResponse;
import com.customPokemonApi.customPokemonApi.services.pokemon.PokemonServiceImpl;




@RestController
@RequestMapping(
		value="/api/v1/pokemons",
		consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE, ALL_VALUE},
		produces = {APPLICATION_JSON_VALUE})
public class PokemonController {
	
	@Autowired
	private PokemonServiceImpl pokemonService;
	
	
	@GetMapping("")
	public ResponseEntity<PokemonGeneralResponse> getAllPokemons(){
		ResponseEntity<PokemonGeneralResponse> responseEntity;
		PokemonGeneralResponse serviceResponse = pokemonService.getPokemonList();
        responseEntity = new ResponseEntity<>(serviceResponse, serviceResponse.getHttpStatus());
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PokemonGeneralResponse> getPokemonById(@PathVariable() Integer id){
		ResponseEntity<PokemonGeneralResponse> responseEntity;
		PokemonGeneralResponse serviceResponse = pokemonService.getPokemonById(id);
        responseEntity = new ResponseEntity<>(serviceResponse, serviceResponse.getHttpStatus());
		return responseEntity;
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<PokemonGeneralResponse> getPokemonById(@PathVariable() String name){
		ResponseEntity<PokemonGeneralResponse> responseEntity;
		PokemonGeneralResponse serviceResponse = pokemonService.getPokemonByName(name);
        responseEntity = new ResponseEntity<>(serviceResponse, serviceResponse.getHttpStatus());
		return responseEntity;
	}
	

}
