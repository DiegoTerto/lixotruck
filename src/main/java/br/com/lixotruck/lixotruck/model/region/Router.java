package br.com.lixotruck.lixotruck.model.region;

import br.com.lixotruck.lixotruck.model.region.dtos.create.CreateOrUpdateRouterDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Router {

    private String routerCode;

    private String truckPlate;

    private List<SubRouter> subRouters;

    public static Router of(CreateOrUpdateRouterDTO dto) {
        var router = new Router();
        router.routerCode = dto.routerCode();
        router.truckPlate = dto.truckPlate();
        router.subRouters = SubRouter.ofList(dto.subRouters());
        return router;
    }

    public static List<Router> ofList(List<CreateOrUpdateRouterDTO> createOrUpdateRouterDTOS) {
        return createOrUpdateRouterDTOS.stream().map(Router::of).collect(Collectors.toList());
    }
}
