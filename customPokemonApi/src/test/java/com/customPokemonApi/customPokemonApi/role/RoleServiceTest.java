package com.customPokemonApi.customPokemonApi.role;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.customPokemonApi.customPokemonApi.models.rolePack.ERole;
import com.customPokemonApi.customPokemonApi.models.rolePack.Role;
import com.customPokemonApi.customPokemonApi.repository.RoleRepository;
import com.customPokemonApi.customPokemonApi.services.RoleService;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

	@Mock
	private RoleRepository roleRepository;
	
	private RoleService roleService;
	private Role role;
	
	@BeforeEach
	private void config() {
		roleService = new RoleService(roleRepository);
		role = new Role(ERole.USER);
	}
	
	@Test
	public void findRoleOk() {
		when(roleRepository.findByName(ERole.USER)).thenReturn(Optional.of(role));
		assertNotNull(roleService.findByErole(ERole.USER), "Devuelve un nulo");
	}
	
	@Test
	public void findRoleBad() {
		when(roleRepository.findByName(ERole.ADMIN)).thenReturn(Optional.empty());
		assertNull(roleService.findByErole(ERole.ADMIN), "Devuelve un objeto");
	}
}
