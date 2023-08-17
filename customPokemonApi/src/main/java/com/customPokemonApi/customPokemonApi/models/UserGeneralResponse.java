package com.customPokemonApi.customPokemonApi.models;

import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UserGeneralResponse<T> {

		@JsonProperty("response")
	    private T response;

	    @JsonProperty("status")
	    private HttpStatus httpStatus;

	    @JsonProperty("userMessages")
	    private UnifiedSet<String> userMessages = UnifiedSet.newSet();

	    public UserGeneralResponse() {
	       
	    }
	    

	    public UserGeneralResponse(T response, HttpStatus httpStatus) {
	        this.response = response;
	        this.httpStatus = httpStatus;
	    }
	    
	    public T getResponse() {
			return response;
		}


		public void setResponse(T response) {
			this.response = response;
		}


		public HttpStatus getHttpStatus() {
			return httpStatus;
		}


		public void setHttpStatus(HttpStatus httpStatus) {
			this.httpStatus = httpStatus;
		}


		public UnifiedSet<String> getUserMessages() {
			return userMessages;
		}


		public void setUserMessages(UnifiedSet<String> userMessages) {
			this.userMessages = userMessages;
		}
}
