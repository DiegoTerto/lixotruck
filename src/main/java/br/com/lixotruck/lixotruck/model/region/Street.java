package br.com.lixotruck.lixotruck.model.region;

import br.com.lixotruck.lixotruck.model.region.dtos.create.CreateOrUpdateStreetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Street {

    private String name;

    public static Street of(CreateOrUpdateStreetDTO dto) {
        var street = new Street();
        street.name = dto.name();
        return street;
    }

    public static List<Street> ofList(List<CreateOrUpdateStreetDTO> createOrUpdateStreetDTOS) {
        return createOrUpdateStreetDTOS.stream().map(Street::of).collect(Collectors.toList());
    }
}
