package com.customPokemonApi.customPokemonApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customPokemonApi.customPokemonApi.models.rolePack.ERole;
import com.customPokemonApi.customPokemonApi.models.rolePack.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	public Optional<Role> findByName(ERole name);
	
	public List<Role> findAll();
}
