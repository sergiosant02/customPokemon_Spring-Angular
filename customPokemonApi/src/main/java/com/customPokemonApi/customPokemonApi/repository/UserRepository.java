package com.customPokemonApi.customPokemonApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.customPokemonApi.customPokemonApi.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer>  {

}
