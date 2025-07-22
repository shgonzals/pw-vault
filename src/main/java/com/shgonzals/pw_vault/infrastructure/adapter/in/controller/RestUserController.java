package com.shgonzals.pw_vault.infrastructure.adapter.in.controller;

import com.shgonzals.pw_vault.application.port.in.RegisterUserUseCase;
import com.shgonzals.pw_vault.domain.model.User;
import com.shgonzals.pw_vault.infrastructure.adapter.in.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Usuarios", description = "Operaciones sobre usuarios")
@RestController
@RequestMapping("/api/users")
public class RestUserController {

	public RestUserController(RegisterUserUseCase registerUser) {
		this.registerUser = registerUser;
	}

	private final RegisterUserUseCase registerUser;

	@Operation(summary = "Registra un nuevo usuario",
			description = "Crea un usuario nuevo en la base de datos")
	@ApiResponse(responseCode = "200", description = "Usuario creado correctamente")
	@PostMapping
	public ResponseEntity<?> register(@RequestBody UserDto dto) {
		registerUser.register(dto.username(), dto.email(), dto.password());
		return ResponseEntity.ok().build();
	}
}
