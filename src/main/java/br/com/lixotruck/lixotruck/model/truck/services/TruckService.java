package br.com.lixotruck.lixotruck.model.truck.services;

import br.com.lixotruck.lixotruck.model.truck.TruckDTO;
import br.com.lixotruck.lixotruck.model.truck.Truck;
import br.com.lixotruck.lixotruck.model.truck.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TruckService {

    private final TruckRepository truckRepository;

    private final CreateTruckValidation createTruckValidation;

    @Autowired
    public TruckService(TruckRepository truckRepository, CreateTruckValidation createTruckValidation) {
        this.truckRepository = truckRepository;
        this.createTruckValidation = createTruckValidation;
    }

    public void createTruck(TruckDTO dto) {
        createTruckValidation.validateExistsTruckByPlate(dto.plate());

        Truck newTruck = new Truck(dto, UUID.randomUUID());
        truckRepository.save(newTruck);
    }

    public Page<TruckDTO> list(Pageable pageable) {
        return truckRepository.findAll(pageable).map(TruckDTO::new);
    }

    public void update(TruckDTO dto, UUID id) {
        Truck truck = truckRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        truck.update(dto);
        truckRepository.save(truck);
    }

    public void delete(UUID id) {
        truckRepository.deleteById(id);
    }
}
