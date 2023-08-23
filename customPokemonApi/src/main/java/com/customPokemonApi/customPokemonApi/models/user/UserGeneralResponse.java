package com.customPokemonApi.customPokemonApi.models.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGeneralResponse<T> {

		@JsonProperty("response")
	    private T response;

	    @JsonProperty("status")
	    private HttpStatus httpStatus;

	    @JsonProperty("userMessages")
	    private Set<String> userMessages = new HashSet<String>();

	    public UserGeneralResponse() {
	       
	    }
	    

	    public UserGeneralResponse(T response, HttpStatus httpStatus) {
	        this.response = response;
	        this.httpStatus = httpStatus;
	    }
	    
}
