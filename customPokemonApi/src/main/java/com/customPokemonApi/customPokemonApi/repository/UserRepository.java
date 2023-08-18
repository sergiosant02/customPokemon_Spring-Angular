package com.customPokemonApi.customPokemonApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.user.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>  {
	
	@Query("SELECT COUNT(c) = 1 FROM UserModel c WHERE c.mail = ?1 AND c.password = ?2")
	public Boolean isValidLogin(String mail, String password);
	
	Boolean existsByMail(String mail);
	
	Boolean existsByUsername(String username);
	
	Optional<UserModel> findByMail(String mail);
	
	Optional<UserModel> findByUsername(String username);
}
