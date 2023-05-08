package br.com.lixotruck.lixotruck.controller;

import br.com.lixotruck.lixotruck.model.user.CreateUserDTO;
import br.com.lixotruck.lixotruck.model.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public void create(@RequestBody @Valid CreateUserDTO dto) {
        userService.create(dto);
    }
}
