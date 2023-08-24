package com.customPokemonApi.customPokemonApi.services.pokemon;

import java.util.Optional;

import com.customPokemonApi.customPokemonApi.models.pokemon.NameStat;

public interface NameStatService {
		public Optional<NameStat> getNameStatByName(String name);
		public NameStat save(NameStat nameStat);
		public NameStat manageNameStat(NameStat nameStat);

}
