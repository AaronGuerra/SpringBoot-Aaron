package com.example.tiendaonline.dto;


import lombok.Builder;

@Builder
public record ProductoResponseDTO(
        Long id_producto,
        String nombre,
        Double precio,
        String categoria
) {
}
