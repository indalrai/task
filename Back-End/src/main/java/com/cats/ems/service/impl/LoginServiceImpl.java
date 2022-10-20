package com.cats.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cats.ems.model.CredentialManager;

import com.cats.ems.repo.CredentialsRepository;

@Service
public class LoginServiceImpl {

	@Autowired
	private CredentialsRepository credentialsRepository;

	public CredentialManager CredentialManager(CredentialManager credentialManager) {
		CredentialManager cManager = new CredentialManager();
		cManager.setLoginId(cManager.getLoginId());
		cManager.setPassword(cManager.getPassword());
		credentialsRepository.save(cManager);

		return cManager;
	}
}
