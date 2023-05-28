package br.com.lixotruck.lixotruck.model.user.service;

import br.com.lixotruck.lixotruck.model.user.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ValidateExistUserService validateExistUserService;

    @Test
    void shouldCreateOK() {
        CreateUserDTO createUserDTO = new CreateUserDTO("name", "username", "email", "pass", "");

        assertDoesNotThrow(() -> userService.create(createUserDTO));
        verify(userRepository).save(any());
    }

    @Test
    void shouldUpdateOK() {
        UpdateUserDTO updateUserDTO = new UpdateUserDTO("name", "username", "email");
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid, "name", "username", "email", "pass", true);

        when(userRepository.findById(any())).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> userService.update(updateUserDTO, uuid));
        verify(userRepository).save(any());
    }

//    @Test
//    void shouldListOK() {
//        UUID uuid = UUID.randomUUID();
//        UserDTO userDTO = new UserDTO(uuid, "name", "username", "email", true);
//        Page<UserDTO> page = Page(userDTO);
//
//        assertDoesNotThrow(() -> userService.list());
//    }

    @Test
    void shouldDeleteOK() {
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid, "name", "username", "email", "pass", true);

        when(userRepository.findById(any())).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> userService.delete(uuid));
    }
}
