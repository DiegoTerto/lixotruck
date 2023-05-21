package br.com.lixotruck.lixotruck.model.driver;

import java.util.UUID;

public record UpdateDriverDTO(
        UUID userId,

        String cnh
) {
}
