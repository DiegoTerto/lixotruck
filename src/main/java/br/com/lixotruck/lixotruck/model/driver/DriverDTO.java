package br.com.lixotruck.lixotruck.model.driver;

import br.com.lixotruck.lixotruck.model.user.UserDTO;

import java.util.UUID;

public record DriverDTO(

        UUID driverId,

        UserDTO user,

        String cnh
) {

    public DriverDTO(Driver driver) {
        this(
                driver.getId(),
                new UserDTO(driver.getUser()),
                driver.getCnh()
        );
    }
}
