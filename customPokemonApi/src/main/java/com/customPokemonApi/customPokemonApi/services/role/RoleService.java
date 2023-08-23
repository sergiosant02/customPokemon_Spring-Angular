package com.customPokemonApi.customPokemonApi.services.role;

import java.util.Optional;


import com.customPokemonApi.customPokemonApi.models.rolePack.ERole;
import com.customPokemonApi.customPokemonApi.models.rolePack.Role;

public interface RoleService {
		

	public Role findByErole(ERole eRole);
	
	public Optional<Role> findByName(String role);

}
