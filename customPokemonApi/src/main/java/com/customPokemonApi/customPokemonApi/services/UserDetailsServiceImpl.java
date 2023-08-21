package com.customPokemonApi.customPokemonApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.customPokemonApi.customPokemonApi.models.CreateAccountCredentials;
import com.customPokemonApi.customPokemonApi.models.rolePack.ERole;
import com.customPokemonApi.customPokemonApi.models.rolePack.Role;
import com.customPokemonApi.customPokemonApi.models.user.UserDetailsImpl;
import com.customPokemonApi.customPokemonApi.models.user.UserModel;
import com.customPokemonApi.customPokemonApi.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	 
	 private UserRepository userRepository;
	 private RoleService roleService;
	 
	 @Autowired
	 public UserDetailsServiceImpl(UserRepository userRepository, RoleService roleService) {
		 this.userRepository = userRepository;
		 this.roleService = roleService;
	 }

	 @Override
	 @Transactional
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   UserModel user = userRepository.findByUsername(username)
	       .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

	   return UserDetailsImpl.build(user);
	 }
	 
	 @Transactional
	 public UserModel save(UserModel user) {
		 return userRepository.save(user);
	 }
	 
	 @Transactional
	 public Boolean existsByUsername(String username) {
		 return userRepository.existsByUsername(username);
	 }
	 
	 @Transactional
	 public Boolean existsByMail(String mail) {
		 return userRepository.existsByMail(mail);
	 }
	 
	 @Transactional
	 public UserModel createUserByCredentials(CreateAccountCredentials credentials, ERole eRole) {
		UserModel user = UserModel.byCredentials(credentials);

	    Role role = roleService.findByErole(eRole);
	    if(role != null) {
	    	user.setRole(role);
	    	user = save(user);
	    } else {
	    	user = null;
	    }
	    return user;
	 }

}
