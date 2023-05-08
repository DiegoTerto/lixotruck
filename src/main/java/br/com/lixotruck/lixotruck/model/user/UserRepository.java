package br.com.lixotruck.lixotruck.model.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {
}
