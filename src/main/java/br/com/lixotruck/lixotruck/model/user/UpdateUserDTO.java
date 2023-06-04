package br.com.lixotruck.lixotruck.model.user;

import jakarta.validation.constraints.Email;

public record UpdateUserDTO(
        String name,

        String username,

        @Email
        String email
) {
}
