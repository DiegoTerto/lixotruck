package br.com.lixotruck.lixotruck.model.driver.service;

import br.com.lixotruck.lixotruck.controller.CreateDriverDTO;
import br.com.lixotruck.lixotruck.model.driver.Driver;
import br.com.lixotruck.lixotruck.model.driver.DriverDTO;
import br.com.lixotruck.lixotruck.model.driver.DriverRepository;
import br.com.lixotruck.lixotruck.model.driver.UpdateDriverDTO;
import br.com.lixotruck.lixotruck.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    UserRepository userRepository;

    public DriverDTO create(CreateDriverDTO dto) {
        var user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var driver = new Driver(dto, user);
        driverRepository.save(driver);
        return new DriverDTO(driver);
    }

    public DriverDTO update(UpdateDriverDTO dto, UUID id) {
        var driver = driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
        driver.update(dto);

        if (dto.userId() != null && dto.userId() != driver.getUserId()) {
            var newUser = userRepository.findById(dto.userId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            driver.updateUser(newUser);
        }
        driverRepository.save(driver);
        return new DriverDTO(driver);
    }

    public Page<DriverDTO> list(Pageable pageable) {
        return driverRepository.findAll(pageable).map(DriverDTO::new);
    }

    public void delete(UUID id) {
        var driver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motorista não encontra"));
        driverRepository.delete(driver);
    }
}
