package br.com.lixotruck.lixotruck.model.region;

import br.com.lixotruck.lixotruck.model.region.dtos.create.CreateOrUpdateRegionDTO;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    private UUID id;

    private String name;

    private String regionCode;

    private List<Router> routers;

    public Region(CreateOrUpdateRegionDTO dto) {
        this.id = UUID.randomUUID();
        this.name = dto.name();
        this.regionCode = dto.regionCode();
        this.routers = Router.ofList(dto.routers());
    }

    public void update(CreateOrUpdateRegionDTO dto) {
        if (dto.name() != null) {
            this.name = dto.name();
        }
        if (dto.regionCode() != null) {
            this.regionCode = dto.regionCode();
        }
        if (!dto.routers().isEmpty()) {
            this.routers = Router.ofList(dto.routers());
        }
    }
}
