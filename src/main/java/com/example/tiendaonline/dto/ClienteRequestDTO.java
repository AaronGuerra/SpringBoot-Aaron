package com.example.tiendaonline.dto;

public record ClienteRequestDTO(
        String nombre,
        String apellido,
        String correo,
        String telefono,
        String direccion
) {
}
