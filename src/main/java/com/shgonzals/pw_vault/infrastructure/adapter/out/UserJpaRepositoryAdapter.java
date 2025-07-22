package com.shgonzals.pw_vault.infrastructure.adapter.out;

import com.shgonzals.pw_vault.application.port.out.SaveUserPort;
import com.shgonzals.pw_vault.domain.model.User;
import com.shgonzals.pw_vault.infrastructure.persistence.SpringDataUserRepository;
import com.shgonzals.pw_vault.infrastructure.persistence.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserJpaRepositoryAdapter implements SaveUserPort {

	@Autowired
	private SpringDataUserRepository repo;

	@Override
	public User save(User user) {
		UserEntity entity = UserEntity.fromDomain(user);
		return repo.save(entity).toDomain();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return repo.findByEmail(email)
						 .map(UserEntity::toDomain);
	}

	@Override
	public Optional<User> findById(UUID id) {
		return repo.findById(id.toString())
						 .map(UserEntity::toDomain);
	}

	@Override
	public boolean existsByEmail(String email) {
		return repo.existsByEmail(email);
	}
}
