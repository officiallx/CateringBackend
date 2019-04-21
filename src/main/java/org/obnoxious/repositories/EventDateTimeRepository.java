package org.obnoxious.repositories;


import org.obnoxious.entities.EventDateTime;
import org.springframework.data.repository.CrudRepository;

public interface EventDateTimeRepository extends CrudRepository<EventDateTime, Long> {

}
