package br.com.lixotruck.lixotruck.controller;

import br.com.lixotruck.lixotruck.model.user.AuthDTO;
import br.com.lixotruck.lixotruck.model.user.CreateUserDTO;
import br.com.lixotruck.lixotruck.model.user.UpdateUserDTO;
import br.com.lixotruck.lixotruck.model.user.UserDTO;
import br.com.lixotruck.lixotruck.model.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @PutMapping("/{id}")
    public void update(
            @RequestBody @Valid UpdateUserDTO dto,
            @PathVariable UUID id
    ) {
        userService.update(dto, id);
    }

    @GetMapping()
    public Page<UserDTO> list(
            @PageableDefault(size = 10)
            Pageable pageable
    ) {
        return userService.list(pageable);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }

     @PutMapping("/authenticate")
    public ResponseEntity authenticate(@RequestBody AuthDTO dto) {
        userService.auth(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getByEmail(@PathVariable String email) {
        var userDTO = userService.getByEmail(email);
        return ResponseEntity.ok().body(userDTO);
    }
}
