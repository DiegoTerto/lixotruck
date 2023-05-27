package br.com.lixotruck.lixotruck.controller;

import br.com.lixotruck.lixotruck.model.driver.CreateDriverDTO;
import br.com.lixotruck.lixotruck.model.driver.DriverDTO;
import br.com.lixotruck.lixotruck.model.driver.UpdateDriverDTO;
import br.com.lixotruck.lixotruck.model.driver.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping()
    public ResponseEntity<DriverDTO> create(
            @RequestBody @Valid CreateDriverDTO dto,
            UriComponentsBuilder uriBuilder
    ) {
        var createdDriver = driverService.create(dto);
        var uri = uriBuilder.path("/driver/{id}").buildAndExpand(createdDriver.driverId()).toUri();

        return ResponseEntity.created(uri).body(createdDriver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverDTO> update(
            @RequestBody UpdateDriverDTO dto,
            @PathVariable UUID id
            ) {
        var updatedDriver = driverService.update(dto, id);
        return ResponseEntity.ok(updatedDriver);
    }

    @GetMapping()
    public ResponseEntity<Page<DriverDTO>> list(
            @PageableDefault(size = 10) Pageable pageable
    ) {
        var list = driverService.list(pageable);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable UUID id
    ) {
        driverService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
