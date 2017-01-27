package ru.alljoint.atctt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ru.alljoint.atctt.entity.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	@Query("{ 'serviceId' : { $regex: ?0 } }")
	public Iterable<Person> findByServiceIds(String regexp);
}
