package com.customPokemonApi.customPokemonApi.services.user;

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
import com.customPokemonApi.customPokemonApi.services.role.RoleServiceImpl;

import jakarta.transaction.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	 
	 private UserRepository userRepository;
	 private RoleServiceImpl roleService;
	 
	 public UserDetailsServiceImpl(UserRepository userRepository, RoleServiceImpl roleService) {
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
		 return userRepository.existsByEmail(mail);
	 }
	 
	 @Transactional
	 public UserModel createUserByCredentials(CreateAccountCredentials credentials) {
		UserModel user = UserModel.byCredentials(credentials);
		Role role = null;
		if(credentials.getRole().isPresent()) {
			role = roleService.findByName(credentials.getRole().get()).orElse(null);
		} 
	    if(role == null) {
	    	role = roleService.findByErole(ERole.USER);
	    } 
	    user.setRole(role);
	    user = save(user);
	    
	    return user;
	 }

}
