package br.com.lixotruck.lixotruck.model.driver;

import br.com.lixotruck.lixotruck.controller.CreateDriverDTO;
import br.com.lixotruck.lixotruck.model.user.User;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    private UUID id;

    private User user;

    private String cnh;

    public Driver(CreateDriverDTO dto, User user) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.cnh = dto.cnh();
    }

    public void update(UpdateDriverDTO dto) {
        if (dto.cnh() != null) {
            this.cnh = dto.cnh();
        }
    }

    public void updateUser(User newUser) {
        this.user = newUser;
    }

    public UUID getUserId() {
        return user.getId();
    }
}
