package com.shgonzals.pw_vault.domain.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class User {

	private UUID id;
	private String username;
	private String email;
	private String password;

	public User(UUID id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
