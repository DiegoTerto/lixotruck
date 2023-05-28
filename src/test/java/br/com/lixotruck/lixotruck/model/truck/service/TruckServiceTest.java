package br.com.lixotruck.lixotruck.model.truck.service;

import br.com.lixotruck.lixotruck.model.truck.Truck;
import br.com.lixotruck.lixotruck.model.truck.TruckDTO;
import br.com.lixotruck.lixotruck.model.truck.TruckRepository;
import br.com.lixotruck.lixotruck.model.truck.TruckStatus;
import br.com.lixotruck.lixotruck.model.truck.services.CreateTruckValidation;
import br.com.lixotruck.lixotruck.model.truck.services.TruckService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class TruckServiceTest {

    @InjectMocks
    private TruckService truckService;

    @Mock
    private TruckRepository truckRepository;

    @Mock
    private CreateTruckValidation createTruckValidation;

    @Test
    void shouldCreateTruckOK() {
        UUID id = UUID.randomUUID();
        TruckDTO truckDTO = new TruckDTO(id, "plate", TruckStatus.OK);
        Truck newTruck = new Truck(truckDTO, id);

        when(truckRepository.save(any())).thenReturn(newTruck);

        assertDoesNotThrow(() -> truckService.createTruck(truckDTO));
        verify(truckRepository).save(any());
    }

    @Test
    void shouldUpdateOK() {
        UUID id = UUID.randomUUID();
        TruckDTO truckDTO = new TruckDTO(id, "plate", TruckStatus.OK);
        TruckDTO truckDTOUpdate = new TruckDTO(id, "plate", TruckStatus.BROKE);
        Truck truck = new Truck(truckDTO, id);

        when(truckRepository.save(any())).thenReturn(truck);
        when(truckRepository.findById(id)).thenReturn(Optional.of(truck));

        assertDoesNotThrow(() -> truckService.update(truckDTOUpdate, id));
        verify(truckRepository).save(any());
        verify(truckRepository).findById(any());
        assertEquals(TruckStatus.BROKE, truck.getStatus());
    }

    @Test
    void shouldDeleteOK() {
        UUID id = UUID.randomUUID();

        doNothing().when(truckRepository).delete(any());

        assertDoesNotThrow(() -> truckService.delete(id));
    }
}
