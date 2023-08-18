package com.customPokemonApi.customPokemonApi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer>  {
	
	@Query("SELECT COUNT(c) = 1 FROM UserModel c WHERE c.mail = ?1 AND c.password = ?2")
	public Boolean isValidLogin(String mail, String password);
}
