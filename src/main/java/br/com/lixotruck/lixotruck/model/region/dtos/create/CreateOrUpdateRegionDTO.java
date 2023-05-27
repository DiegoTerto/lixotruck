package br.com.lixotruck.lixotruck.model.region.dtos.create;

import java.util.List;

public record CreateOrUpdateRegionDTO(

        String name,

        String regionCode,

        List<CreateOrUpdateRouterDTO> routers
) {
}
