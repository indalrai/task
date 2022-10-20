package com.cats.ems.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cats.ems.dto.CredentialManagerDTO;
import com.cats.ems.model.CredentialManager;
import com.cats.ems.repo.CredentialsRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private CredentialsRepository credentialsRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		CredentialManager user = credentialsRepository.findByUserId(userId);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userId);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(),
				new ArrayList<>());
	}

	public CredentialManager save(CredentialManagerDTO credentialManagerDTO) {

		CredentialManager credentialManager = new CredentialManager();
		credentialManager.setUserId(credentialManagerDTO.getUserId());
//		credentialManager.setPassword(credentialManagerDTO.getPassword());
		credentialManager.setPassword(bcryptEncoder.encode(credentialManagerDTO.getPassword()));
		return credentialsRepository.save(credentialManager);

	}

	public static boolean isValidUserId(String password, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

}