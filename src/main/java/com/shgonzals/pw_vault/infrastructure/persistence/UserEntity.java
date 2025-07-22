package com.shgonzals.pw_vault.infrastructure.persistence;

import com.shgonzals.pw_vault.domain.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

	@Id
	private String id;
	private String username;
	private String email;
	private String password;

	public static UserEntity fromDomain(User user) {
		return UserEntity.builder()
			 .id(user.getId().toString())
			 .username(user.getUsername())
			 .email(user.getEmail())
			 .password(user.getPassword())
			 .build();
	}

	public User toDomain() {
		return new User(
				UUID.fromString(id),
				username,
				email,
				password
		);
	}
}
