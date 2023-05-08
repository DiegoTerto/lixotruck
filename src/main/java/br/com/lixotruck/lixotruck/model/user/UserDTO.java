package br.com.lixotruck.lixotruck.model.user;

import java.util.UUID;

public record UserDTO(
        UUID id,
        String name,
        String username,
        String email,

        Boolean active
) {
    public UserDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getActive()
        );
    }
}
