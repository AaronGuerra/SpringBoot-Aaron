package com.example.tiendaonline.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime fecha,
        Integer status,
        String mensaje
) {
}