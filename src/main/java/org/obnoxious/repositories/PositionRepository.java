package org.obnoxious.repositories;

import org.obnoxious.entities.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Long> {
}
