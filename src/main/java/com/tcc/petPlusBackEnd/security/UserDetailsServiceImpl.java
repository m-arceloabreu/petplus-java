package com.tcc.petPlusBackEnd.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcc.petPlusBackEnd.model.Cliente;
import com.tcc.petPlusBackEnd.repository.ClienteRepository;

@Service
public class UserDetailsServiceImpl /* implements UserDetailsService */{
	
	@Autowired
	private ClienteRepository userRepository;
	
	
	/*
	 * @Override public UserDetails loadUserByUsername(String userName) throws
	 * UsernameNotFoundException { Optional<Cliente> user =
	 * userRepository.findByNome(userName); user.orElseThrow(() -> new
	 * UsernameNotFoundException(userName+ "not found")); return
	 * user.map(UserDetailsImpl::new).get(); }
	 */
	

}
