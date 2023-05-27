package br.com.lixotruck.lixotruck.model.region;

import br.com.lixotruck.lixotruck.model.region.dtos.create.CreateOrUpdateSubRouterDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubRouter {

    private String subRouterCode;

    private List<Street> streets;

    public static SubRouter of(CreateOrUpdateSubRouterDTO dto) {
        var subRouter = new SubRouter();
        subRouter.subRouterCode = dto.subRouterCode();
        subRouter.streets = Street.ofList(dto.streets());
        return subRouter;
    }

    public static List<SubRouter> ofList(List<CreateOrUpdateSubRouterDTO> createOrUpdateSubRouterDTOS) {
        return createOrUpdateSubRouterDTOS.stream().map(SubRouter::of).collect(Collectors.toList());
    }
}
