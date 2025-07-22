package com.shgonzals.pw_vault.application.port.in;

import com.shgonzals.pw_vault.domain.model.User;

public interface RegisterUserUseCase {
	User register(String username, String email, String password);

}
