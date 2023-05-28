package br.com.lixotruck.lixotruck.model.user.service;

import br.com.lixotruck.lixotruck.model.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class ValidateExistUserServiceTest {

    @InjectMocks
    private ValidateExistUserService validateExistUserService;

    @Mock
    private UserRepository userRepository;

    @Test
    void shouldValidateExistByUsernameException() {
        String username = "username";
        when(userRepository.existsByUsername(username)).thenReturn(true);

        var ex = assertThrows(RuntimeException.class,
                () -> validateExistUserService.validateExistByUsername(username));

        assertEquals("Já existe um usuário com esse username", ex.getMessage());
    }

    @Test
    void shouldValidateExistByUsernameOK() {
        String username = "username";
        when(userRepository.existsByUsername(username)).thenReturn(false);

         assertDoesNotThrow(() -> validateExistUserService.validateExistByUsername(username));

        verify(userRepository).existsByUsername(username);
    }

    @Test
    void shouldValidateExistByEmailException() {
        String email = "email@gmail.com";
        when(userRepository.existsByEmail(email)).thenReturn(true);

        var ex = assertThrows(RuntimeException.class,
                () -> validateExistUserService.validateExistByEmail(email));

        assertEquals("Já existe um usuário com esse email", ex.getMessage());
    }

    @Test
    void shouldValidateExistByEmailOK() {
        String email = "email@gmail.com";
        when(userRepository.existsByEmail(email)).thenReturn(false);

        assertDoesNotThrow(() -> validateExistUserService.validateExistByEmail(email));

        verify(userRepository).existsByEmail(email);
    }
}
