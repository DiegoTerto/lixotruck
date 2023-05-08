package br.com.lixotruck.lixotruck.model.truck;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface TruckRepository extends MongoRepository<Truck, UUID> {

    Truck findByPlate(String plate);

    Boolean existsByPlate(String plate);
}
