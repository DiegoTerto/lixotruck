package br.com.lixotruck.lixotruck.model.region.dtos;

import br.com.lixotruck.lixotruck.model.region.Region;
import br.com.lixotruck.lixotruck.model.region.Router;

import java.util.List;
import java.util.UUID;

public record RegionDTO(
        UUID id,
        String regionCode,
        String name,
        List<RouterDTO> routers
) {
    public RegionDTO(Region region) {
        this(
                region.getId(),
                region.getName(),
                region.getRegionCode(),
                region.getRouters().stream()
                        .map(RouterDTO::new)
                        .toList()
        );
    }

}
