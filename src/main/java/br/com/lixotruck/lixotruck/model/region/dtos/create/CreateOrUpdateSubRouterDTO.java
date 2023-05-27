package br.com.lixotruck.lixotruck.model.region.dtos.create;

import java.util.List;

public record CreateOrUpdateSubRouterDTO(
        String subRouterCode,

        List<CreateOrUpdateStreetDTO> streets
) {
}
