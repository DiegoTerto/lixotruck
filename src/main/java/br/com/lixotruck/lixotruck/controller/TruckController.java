package br.com.lixotruck.lixotruck.controller;

import br.com.lixotruck.lixotruck.model.truck.TruckDTO;
import br.com.lixotruck.lixotruck.model.truck.services.TruckService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("truck")
public class TruckController {

    private final TruckService truckService;

    @Autowired
    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @PostMapping()
    @Transactional
    public void createTruck(@RequestBody @Valid TruckDTO truck) {
        truckService.createTruck(truck);
    }

    @GetMapping()
    public Page<TruckDTO> list(
            @PageableDefault(size = 10)
            Pageable pageable
    ) {
        return truckService.list(pageable);
    }

    @PutMapping("/{id}")
    @Transactional
    public void update(@RequestBody TruckDTO dto, @PathVariable UUID id) {
        truckService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable UUID id) {
        truckService.delete(id);
    }
}
