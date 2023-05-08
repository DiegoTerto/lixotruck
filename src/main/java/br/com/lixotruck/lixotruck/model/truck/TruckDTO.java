package br.com.lixotruck.lixotruck.model.truck;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record TruckDTO(

        UUID id,

        @NotBlank(message = "Placa não pode ser nula ou vazia")
        String plate,
        TruckStatus status

) {
        public TruckDTO(Truck truck) {
                this(truck.getId(), truck.getPlate(),truck.getStatus());
        }
}
