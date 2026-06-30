package com.example.tiendaonline.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ProductoRequestDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        String nombre,
        @NotNull(message = "La descripción es obligatoria")
        String descripcion,
        @NotNull(message = "El precio es obligatorio")
        @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
        Double precio,
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock,
        @NotBlank(message = "La categoría no puede estar vacía")
        String categoria
) {
}
