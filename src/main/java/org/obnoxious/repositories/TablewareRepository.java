package org.obnoxious.repositories;

import org.obnoxious.entities.Tableware;
import org.springframework.data.repository.CrudRepository;

public interface TablewareRepository extends CrudRepository<Tableware, Long> {
}
