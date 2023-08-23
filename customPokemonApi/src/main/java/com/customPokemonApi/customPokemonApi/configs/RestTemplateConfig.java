package com.customPokemonApi.customPokemonApi.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateConfig {

	@Value("${poke.api.pokemon.fqdn}")
	private String urlApiPokemon;
	
	@Bean
	@Qualifier("PokemonApiTemplate")
	public RestTemplate pokemonApiRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(urlApiPokemon));
		return restTemplate;
	}
}
