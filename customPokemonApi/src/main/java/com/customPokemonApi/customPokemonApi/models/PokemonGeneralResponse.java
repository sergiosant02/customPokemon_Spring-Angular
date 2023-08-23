package com.customPokemonApi.customPokemonApi.models;

import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonGeneralResponse<T> {

	@JsonProperty("response")
    private T response;

    @JsonProperty("status")
    private HttpStatus httpStatus;

    @JsonProperty("userMessages")
    private UnifiedSet<String> userMessages = UnifiedSet.newSet();

    public PokemonGeneralResponse() {
    }

    public PokemonGeneralResponse(T response, HttpStatus httpStatus) {
        this.response = response;
        this.httpStatus = httpStatus;
    }

	@Override
	public String toString() {
		return "PokemonGeneralResponse [response=" + response + ", httpStatus=" + httpStatus + ", userMessages="
				+ userMessages + "]";
	}


}