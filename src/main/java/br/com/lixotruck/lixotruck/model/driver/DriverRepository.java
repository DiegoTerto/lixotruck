package br.com.lixotruck.lixotruck.model.driver;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface DriverRepository extends MongoRepository<Driver, UUID> {
}
