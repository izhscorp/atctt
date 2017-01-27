package ru.alljoint.atctt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ru.alljoint.atctt.entity.Claim;
import ru.alljoint.atctt.entity.Service;

public interface ServiceRepository extends MongoRepository<Service, String> {
	@Query("{'categoryOfRecipients' : ?0}")
	public List<Service> findByClaim(Claim claim);
}
