package br.com.lixotruck.lixotruck.model.user.service;

import br.com.lixotruck.lixotruck.model.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ValidateExistUserService validateExistUserService;

    @Autowired
    public UserService(UserRepository userRepository, ValidateExistUserService validateExistUserService) {
        this.userRepository = userRepository;
        this.validateExistUserService = validateExistUserService;
    }

    public void create(CreateUserDTO dto) {
        validateExistUserService.validateExistByEmail(dto.email());
        validateExistUserService.validateExistByUsername(dto.username());
        User newUser = new User(dto, UUID.randomUUID());
        userRepository.save(newUser);
}

    public void update(UpdateUserDTO dto, UUID id) {
        validateExistUserService.validateExistByEmail(dto.email());
        validateExistUserService.validateExistByUsername(dto.username());
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        user.update(dto);
        userRepository.save(user);
    }

    public Page<UserDTO> list(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserDTO::new);
    }

    public void delete(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        user.inactive();
        userRepository.save(user);
    }

    public void auth(AuthDTO dto) {
        var user = userRepository.findByEmail(dto.email()).orElseThrow(() -> new RuntimeException("Email incorreto"));
        if (!user.getPassword().equals(dto.password())) {
            throw new RuntimeException("Senha incorreta");
        }
    }

    public UserDTO getByEmail(String email) {
        var user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email incorreto"));
        return new UserDTO(user);
    }
}
