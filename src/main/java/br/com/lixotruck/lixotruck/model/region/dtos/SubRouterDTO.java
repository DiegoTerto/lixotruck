package br.com.lixotruck.lixotruck.model.region.dtos;

import br.com.lixotruck.lixotruck.model.region.SubRouter;

import java.util.List;

public record SubRouterDTO(
        String subRouterCode,
        List<StreetDTO> streets
) {

    public SubRouterDTO(SubRouter subRouter) {
        this(
                subRouter.getSubRouterCode(),
                subRouter.getStreets()
                        .stream()
                        .map(StreetDTO::new)
                        .toList()
        );
    }
}
