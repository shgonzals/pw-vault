package com.shgonzals.pw_vault.application.port.out;

import com.shgonzals.pw_vault.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface SaveUserPort {
	User save(User user);
	Optional<User> findByEmail(String email);
	Optional<User> findById(UUID id);
	boolean existsByEmail(String email);
}
