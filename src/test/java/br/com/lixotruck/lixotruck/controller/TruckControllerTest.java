package br.com.lixotruck.lixotruck.controller;

import br.com.lixotruck.lixotruck.model.truck.TruckDTO;
import br.com.lixotruck.lixotruck.model.truck.TruckStatus;
import br.com.lixotruck.lixotruck.model.truck.services.TruckService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.UUID;

import static org.mockito.Mockito.when;

public class TruckControllerTest {

    @InjectMocks
    private TruckController truckController;

    @Mock
    private TruckService truckService;

//    @Test
//    void shouldCreateTruckOK() {
//        truckController.createTruck(createMockTruckDTO());
//    }

    private TruckDTO createMockTruckDTO() {
        UUID id = UUID.randomUUID();
        return new TruckDTO(id, "plate", TruckStatus.OK);
    }
}
