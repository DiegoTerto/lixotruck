package br.com.lixotruck.lixotruck.model.truck;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Truck {

    @Id
    private UUID id;

    private String plate;

    private TruckStatus status;

    public Truck(TruckDTO truckDTO, UUID truckId) {
        this.id = truckId;
        this.plate = truckDTO.plate();
        this.status = truckDTO.status();
    }

    public void update(TruckDTO dto) {
        if (dto.plate() != null) {
            this.plate = dto.plate();
        }
        if (dto.status() != null) {
            this.status = dto.status();
        }
    }
}
