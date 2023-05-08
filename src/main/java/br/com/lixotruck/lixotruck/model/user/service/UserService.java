package br.com.lixotruck.lixotruck.model.user.service;

import br.com.lixotruck.lixotruck.model.user.CreateUserDTO;
import br.com.lixotruck.lixotruck.model.user.User;
import br.com.lixotruck.lixotruck.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(CreateUserDTO dto) {
        User newUser = new User(dto, UUID.randomUUID());
        userRepository.save(newUser);
    }
}
