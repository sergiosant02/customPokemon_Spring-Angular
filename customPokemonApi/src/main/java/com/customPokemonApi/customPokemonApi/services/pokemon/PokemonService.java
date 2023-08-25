package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.List;

import com.customPokemonApi.customPokemonApi.models.PokemonGeneralResponse;
import com.customPokemonApi.customPokemonApi.models.pokemon.Pokemon;

public interface PokemonService {
	public void populateBdPokemon();
	public List<Pokemon> getPokemonList();
	public PokemonGeneralResponse<List<Pokemon>> getPokemonListResponse();
	public PokemonGeneralResponse<Pokemon> getPokemonById(Long id);
	public PokemonGeneralResponse<Pokemon> getPokemonByName(String name);
	public Pokemon getPokemonByIdNetwork(Long id);
	public Pokemon getPokemonByNameNetwork(String name);
	public Pokemon save(Pokemon pokemon);
}
