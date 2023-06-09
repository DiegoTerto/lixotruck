package br.com.lixotruck.lixotruck.model.driver;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateDriverDTO(
        @NotNull
        UUID userId,

        @NotBlank
        String cnh
) {
}
