package com.example.tiendaonline.dto;

import com.example.tiendaonline.model.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteRequestDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        String nombre,
        @NotNull(message = "El apellido es obligatoria")
        String apellido,
        @NotNull(message = "El correo no puede ser nulo")
        @Email(message = "Que sea tipo email es obligatorio")
        String correo,
        @Size(min = 3, max = 12)
        String telefono,
        @NotBlank(message = "La dirección no puede estar vacía")
        String direccion,
        String password,
        Rol rol
) {
}
