package com.example.tiendaonline.auth;

public record LoginRequestDTO(
        String correo,
        String password
) {
}
