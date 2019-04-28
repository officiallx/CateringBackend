package org.obnoxious.repositories;

import org.obnoxious.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository <Order, Long> {
}
