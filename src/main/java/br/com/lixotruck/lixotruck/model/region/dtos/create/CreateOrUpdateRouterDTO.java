package br.com.lixotruck.lixotruck.model.region.dtos.create;

import java.util.List;

public record CreateOrUpdateRouterDTO(
        String routerCode,

        String truckPlate,

        List<CreateOrUpdateSubRouterDTO> subRouters
) {
}
