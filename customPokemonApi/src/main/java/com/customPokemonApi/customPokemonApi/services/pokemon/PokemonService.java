package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.List;

import com.customPokemonApi.customPokemonApi.models.PokemonGeneralResponse;
import com.customPokemonApi.customPokemonApi.models.pokemon.Pokemon;

public interface PokemonService {
	public void populateBdPokemon();
	public PokemonGeneralResponse<List<Pokemon>> getPokemonList();
	public PokemonGeneralResponse<List<Pokemon>> inceasePokemonListData();
	public PokemonGeneralResponse<Pokemon> getPokemonById(Integer id);
	public PokemonGeneralResponse<Pokemon> getPokemonByName(String name);
	public PokemonGeneralResponse<Pokemon> getPokemonByIdNetwork(Integer id);
}