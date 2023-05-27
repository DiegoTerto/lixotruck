package br.com.lixotruck.lixotruck.model.region.service;

import br.com.lixotruck.lixotruck.model.region.Region;
import br.com.lixotruck.lixotruck.model.region.RegionRepository;
import br.com.lixotruck.lixotruck.model.region.dtos.RegionDTO;
import br.com.lixotruck.lixotruck.model.region.dtos.create.CreateOrUpdateRegionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public RegionDTO create(CreateOrUpdateRegionDTO dto) {
        var region = new Region(dto);
        regionRepository.save(region);
        return new RegionDTO(region);
    }

    public Page<RegionDTO> list(Pageable pageable) {
        return regionRepository.findAll(pageable).map(RegionDTO::new);
    }

    public RegionDTO update(CreateOrUpdateRegionDTO dto, UUID id) {
        var region = regionRepository.findById(id).orElseThrow(() -> new RuntimeException("Região não encontrada"));
        region.update(dto);
        regionRepository.save(region);
        return new RegionDTO(region);
    }

    public void delete(UUID id) {
        var region = regionRepository.findById(id).orElseThrow(() -> new RuntimeException("Região não encontrada"));
        regionRepository.delete(region);
    }
}
