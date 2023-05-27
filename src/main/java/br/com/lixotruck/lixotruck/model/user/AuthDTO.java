package br.com.lixotruck.lixotruck.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthDTO(

        @NotBlank
        @Email
        String email,

        @NotBlank
        String password
) {
}
