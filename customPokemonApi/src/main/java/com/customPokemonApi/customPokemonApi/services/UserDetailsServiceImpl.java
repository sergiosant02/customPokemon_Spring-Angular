package com.customPokemonApi.customPokemonApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.customPokemonApi.customPokemonApi.models.user.UserDetailsImpl;
import com.customPokemonApi.customPokemonApi.models.user.UserModel;
import com.customPokemonApi.customPokemonApi.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	 @Autowired
	 UserRepository userRepository;

	 @Override
	 @Transactional
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   UserModel user = userRepository.findByUsername(username)
	       .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

	   return UserDetailsImpl.build(user);
	 }

}
