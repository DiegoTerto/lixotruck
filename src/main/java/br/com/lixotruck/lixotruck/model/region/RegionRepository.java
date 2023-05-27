package br.com.lixotruck.lixotruck.model.region;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface RegionRepository extends MongoRepository<Region, UUID> {
}
