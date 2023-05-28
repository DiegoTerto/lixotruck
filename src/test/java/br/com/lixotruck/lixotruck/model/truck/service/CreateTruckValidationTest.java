package br.com.lixotruck.lixotruck.model.truck.service;

import br.com.lixotruck.lixotruck.model.truck.TruckRepository;
import br.com.lixotruck.lixotruck.model.truck.exceptions.TruckException;
import br.com.lixotruck.lixotruck.model.truck.services.CreateTruckValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CreateTruckValidationTest {

    @InjectMocks
    private CreateTruckValidation createTruckValidation;

    @Mock
    private TruckRepository truckRepository;

    @Test
    void shouldValidateExistsTruckByPlateOK() {
        String plate = "plate";

        when(truckRepository.existsByPlate(plate)).thenReturn(false);

        assertDoesNotThrow(() -> createTruckValidation.validateExistsTruckByPlate(plate));
        verify(truckRepository).existsByPlate(plate);
    }

    @Test
    void shouldValidateExistsTruckByPlateException() {
        String plate = "plate";

        when(truckRepository.existsByPlate(plate)).thenReturn(true);

        TruckException ex = assertThrows(TruckException.class,
                () -> createTruckValidation.validateExistsTruckByPlate(plate));

        verify(truckRepository).existsByPlate(plate);
        assertEquals("Já existe um caminhão com essa placa", ex.getMessage());
    }
}
