package com.customPokemonApi.customPokemonApi.utils;

import java.util.Optional;

import org.springframework.http.HttpStatus;

public class Utils {
	public static<T> HttpStatus getHttpCodeOptional(Optional<T> op) {
		HttpStatus res;
		if(op.isPresent()) {
			res = HttpStatus.OK;
		} else {
			res = HttpStatus.NOT_FOUND;
		}
		return res;
	}
}
