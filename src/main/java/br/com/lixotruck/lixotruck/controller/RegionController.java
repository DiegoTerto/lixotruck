package br.com.lixotruck.lixotruck.controller;

import br.com.lixotruck.lixotruck.model.region.dtos.RegionDTO;
import br.com.lixotruck.lixotruck.model.region.dtos.create.CreateOrUpdateRegionDTO;
import br.com.lixotruck.lixotruck.model.region.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController()
@RequestMapping("region")
public class RegionController {

    @Autowired
    RegionService regionService;

    @PostMapping()
    public ResponseEntity<RegionDTO> create(
            @RequestBody CreateOrUpdateRegionDTO dto,
            UriComponentsBuilder uriBuilder
    ) {
        var createdRegion = regionService.create(dto);
        var uri = uriBuilder.path("/region/{id}").buildAndExpand(createdRegion.id()).toUri();
        return ResponseEntity.created(uri).body(createdRegion);
    }

    @GetMapping()
    public ResponseEntity<Page<RegionDTO>> list(
            @PageableDefault() Pageable pageable
    ) {
        return ResponseEntity.ok(regionService.list(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionDTO> update(
            @RequestBody CreateOrUpdateRegionDTO dto,
            @PathVariable UUID id
    ) {
        var updatedRegion = regionService.update(dto, id);
        return ResponseEntity.ok(updatedRegion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        regionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
