package com.customPokemonApi.customPokemonApi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.customPokemonApi.customPokemonApi.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer>  {
	
	@Query("SELECT COUNT(*) == 1 FROM credentials c WHERE c.mail = ?1 and c.password = ?2")
	public Boolean isValidLogin(String mail, String password);
}
