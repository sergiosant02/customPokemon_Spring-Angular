package com.customPokemonApi.customPokemonApi.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.customPokemonApi.customPokemonApi.models.CreateAccountCredentials;
import com.customPokemonApi.customPokemonApi.models.rolePack.ERole;
import com.customPokemonApi.customPokemonApi.models.rolePack.Role;
import com.customPokemonApi.customPokemonApi.models.user.UserModel;
import com.customPokemonApi.customPokemonApi.repository.RoleRepository;
import com.customPokemonApi.customPokemonApi.repository.UserRepository;
import com.customPokemonApi.customPokemonApi.services.RoleService;
import com.customPokemonApi.customPokemonApi.services.UserDetailsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceDetailsImplTest {

	@Mock
	private UserRepository userRepository;
	@Mock
	private RoleRepository roleRepository;
	
	private UserDetailsServiceImpl userService;
	private RoleService roleService;
	private Role role;

	
	private List<UserModel> userList;
	private List<CreateAccountCredentials> credList;
	
	
	
	@BeforeEach
	private void config() {
		userList = new ArrayList<UserModel>();
		credList = new ArrayList<CreateAccountCredentials>();
		roleService = new RoleService(roleRepository);
		userService = new UserDetailsServiceImpl(userRepository, roleService);
		role = new Role(ERole.USER);
		for(int i= 1; i <=3; i++) {
			String mail = String.format("correo%d@gmail.com", i);
			String password = String.format("password%d", i);
			String username = String.format("username%d", i);
			String name = String.format("name%d", i);
			String lastName = String.format("lastName%d", i);
			CreateAccountCredentials createAccountCredentials = new CreateAccountCredentials(mail,password, username, name, lastName);
			credList.add(createAccountCredentials);
		}
		for(int i = 0; i < credList.size(); i++) {
			userList.add(UserModel.byCredentials(credList.get(i)));
			userList.get(i).setRole(role);
		}
		
	}
	
	@Test
	public void loadUserByUsernameOk () {
		UserModel user = userList.get(0);
		when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
		assertNotNull(userService.loadUserByUsername(user.getUsername()), "Devuelve user nulo");
		
	}
	
	@Test
	public void loadUserByUsernameBad () {
		UserModel user = userList.get(0);
		when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.empty());
		assertThrows(UsernameNotFoundException.class, () -> {userService.loadUserByUsername(user.getUsername());}, "No lanza excepción por carencia de usuario.");
		
	}
	
	@Test
	public void createUserByCredentialsOk () {
		when(roleRepository.findByName(ERole.USER)).thenReturn(Optional.of(role));
		when(userRepository.save(any())).thenReturn(userList.get(0));
		assertEquals(userService.createUserByCredentials(credList.get(0)), userList.get(0));
		
	}
	
	@Test
	public void createUserByCredentialsBad () {
		when(roleRepository.findByName(ERole.USER)).thenReturn(Optional.empty());
		assertEquals(userService.createUserByCredentials(credList.get(0)),null);
		
	}
}
