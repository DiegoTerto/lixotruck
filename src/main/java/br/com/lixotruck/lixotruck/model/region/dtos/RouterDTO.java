package br.com.lixotruck.lixotruck.model.region.dtos;

import br.com.lixotruck.lixotruck.model.region.Router;

import java.util.List;

public record RouterDTO(
        String routerCode,
        String truckPlate,
        List<SubRouterDTO> subRouters
) {

    public RouterDTO(Router router) {
        this(
                router.getRouterCode(),
                router.getTruckPlate(),
                router.getSubRouters()
                        .stream()
                        .map(SubRouterDTO::new)
                        .toList()
        );
    }
}
