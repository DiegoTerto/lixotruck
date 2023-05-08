package br.com.lixotruck.lixotruck.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private UUID id;

    private String name;

    private String username;

    private String email;

    private String password;

    private Boolean active;

    public User(CreateUserDTO createUserDTO, UUID id) {
        this.id = id;
        this.name = createUserDTO.name();
        this.username = createUserDTO.username();
        this.email = createUserDTO.email();
        this.password = createUserDTO.password();
        this.active = true;
    }

    public void update(UpdateUserDTO dto) {
        if (dto.nome() != null) {
            this.name = dto.nome();
        }
        if (dto.email() != null) {
            this.email = dto.email();
        }
        if (dto.username() != null) {
            this.username = dto.username();
        }
    }

    public void inactive() {
        this.active = false;
    }
}
