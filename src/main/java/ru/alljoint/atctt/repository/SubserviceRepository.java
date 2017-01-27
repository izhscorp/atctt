package ru.alljoint.atctt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ru.alljoint.atctt.entity.Subservice;

public interface SubserviceRepository extends MongoRepository<Subservice, String> {

}
