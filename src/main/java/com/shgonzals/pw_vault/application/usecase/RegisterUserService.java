package com.shgonzals.pw_vault.application.usecase;

import com.shgonzals.pw_vault.application.port.in.RegisterUserUseCase;
import com.shgonzals.pw_vault.application.port.out.SaveUserPort;
import com.shgonzals.pw_vault.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegisterUserService implements RegisterUserUseCase {

	private final SaveUserPort saveUserPort;

	public RegisterUserService(SaveUserPort saveUserPort){
		this.saveUserPort = saveUserPort;
	}

	@Override
	public User register(String username, String email, String password) {
		User user = new User(UUID.randomUUID(), username, email, password);
		return saveUserPort.save(user);
	}
}
