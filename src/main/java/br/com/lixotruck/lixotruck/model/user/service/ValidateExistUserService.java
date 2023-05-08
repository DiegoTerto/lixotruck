package br.com.lixotruck.lixotruck.model.user.service;

import br.com.lixotruck.lixotruck.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateExistUserService implements IValidateExistUser {

    private final UserRepository userRepository;

    @Autowired
    public ValidateExistUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateExistByUsername(String username) {
        var exist = userRepository.existsByUsername(username);
        if (exist) {
            throw new RuntimeException("Já existe um usuário com esse username");
        }
    }

    @Override
    public void validateExistByEmail(String email) {
        var exist = userRepository.existsByEmail(email);
        if (exist) {
            throw new RuntimeException("Já existe um usuário com esse email");
        }
    }
}
