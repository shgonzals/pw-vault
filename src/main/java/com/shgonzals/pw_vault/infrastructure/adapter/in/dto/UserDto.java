package com.shgonzals.pw_vault.infrastructure.adapter.in.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDto (
	@NotBlank String username,
	@Email String email,
	@Size(min=8) String password
){}
