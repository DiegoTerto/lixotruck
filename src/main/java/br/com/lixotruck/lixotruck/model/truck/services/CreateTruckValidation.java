package br.com.lixotruck.lixotruck.model.truck.services;

import br.com.lixotruck.lixotruck.model.truck.TruckRepository;
import br.com.lixotruck.lixotruck.model.truck.exceptions.TruckException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTruckValidation {

    private final TruckRepository truckRepository;

    @Autowired
    public CreateTruckValidation(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public void validateExistsTruckByPlate(String plate) {
        var exists = truckRepository.existsByPlate(plate);
        if (exists) {
            throw new TruckException("Já existe um caminhão com essa placa");
        }
    }
}
