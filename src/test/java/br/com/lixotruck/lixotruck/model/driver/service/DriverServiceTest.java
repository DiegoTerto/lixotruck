package br.com.lixotruck.lixotruck.model.driver.service;

import br.com.lixotruck.lixotruck.model.driver.*;
import br.com.lixotruck.lixotruck.model.user.User;
import br.com.lixotruck.lixotruck.model.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class DriverServiceTest {

    @InjectMocks
    private DriverService driverService;

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private DriverDTO driverDTO;

    @Test
    void shouldCreateThrowException() {
        UUID id = UUID.randomUUID();
        CreateDriverDTO newDriver = new CreateDriverDTO(id, "cnh");

        RuntimeException ex = assertThrows(RuntimeException.class, () -> driverService.create(newDriver));

        assertEquals("Usuário não encontrado", ex.getMessage());
    }

    @Test
    void shouldCreateOK() {
        UUID id = UUID.randomUUID();
        CreateDriverDTO newDriver = new CreateDriverDTO(id, "cnh");
        Driver driver = new Driver();

        when(userRepository.findById(any())).thenReturn(Optional.of(createUser()));
        when(driverRepository.save(any())).thenReturn(driver);

        assertDoesNotThrow(() -> driverService.create(newDriver));
        verify(userRepository).findById(any());
        verify(driverRepository).save(any());
    }

    @Test
    void shouldUpdateThrowDriverException() {
        UUID id = UUID.randomUUID();
        UpdateDriverDTO updateDriverDTO = new UpdateDriverDTO(id, "cnh");

        RuntimeException ex = assertThrows(RuntimeException.class, () -> driverService.update(updateDriverDTO, id));

        assertEquals("Motorista não encontrado", ex.getMessage());
    }

    @Test
    void shouldUpdateThrowUserException() {
        UUID id = UUID.randomUUID();
        UpdateDriverDTO updateDriverDTO = new UpdateDriverDTO(id, "cnh");

        when(driverRepository.findById(any())).thenReturn(Optional.of(createDriver()));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> driverService.update(updateDriverDTO, id));

        assertEquals("Usuário não encontrado", ex.getMessage());
    }

    @Test
    void shouldUpdateOK() {
        UUID id = UUID.randomUUID();
        UpdateDriverDTO updateDriverDTO = new UpdateDriverDTO(id, "cnh");
        User user =  new User(id, "name", "username", "email@gmail.com", "pass", true);
        Driver driver = new Driver(id, user, "cnh");

        when(driverRepository.findById(any())).thenReturn(Optional.of(driver));

        assertDoesNotThrow(() -> driverService.update(updateDriverDTO, id));
        verify(driverRepository).findById(any());
        verify(driverRepository).save(any());
    }

    @Test
    void shouldDeleteThrowException() {
        UUID id = UUID.randomUUID();

        RuntimeException ex = assertThrows(RuntimeException.class, () -> driverService.delete(id));

        assertEquals("Motorista não encontrado", ex.getMessage());
    }

    @Test
    void shouldDeleteOK() {
        UUID id = UUID.randomUUID();

        when(driverRepository.findById(any())).thenReturn(Optional.of(createDriver()));

        assertDoesNotThrow(() -> driverService.delete(id));
        verify(driverRepository).findById(any());
    }

    private User createUser() {
        UUID id = UUID.randomUUID();
        return new User(id, "name", "username", "email@gmail.com", "pass", true);
    }

    private Driver createDriver() {
        UUID id = UUID.randomUUID();
        return new Driver(id, createUser(), "cnh");
    }
}
