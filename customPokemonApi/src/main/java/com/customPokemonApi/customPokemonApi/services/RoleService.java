package com.customPokemonApi.customPokemonApi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customPokemonApi.customPokemonApi.models.rolePack.ERole;
import com.customPokemonApi.customPokemonApi.models.rolePack.Role;
import com.customPokemonApi.customPokemonApi.repository.RoleRepository;

import jakarta.transaction.Transactional;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Transactional
	public Role findByErole(ERole eRole) {
		return roleRepository.findByName(eRole).orElse(null);
	}
	
	@Transactional
	public Optional<Role> findByName(String role) {
		Optional<Role> res = roleRepository.findAll().stream()
				.filter(r -> r.getName().toString().toUpperCase().contains(role.toUpperCase()))
				.findFirst();
		return res;
	}

}
