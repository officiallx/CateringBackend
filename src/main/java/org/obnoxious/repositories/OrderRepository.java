package org.obnoxious.repositories;

import org.obnoxious.entities.ApplicationUser;
import org.obnoxious.entities.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository <Order, Long> {
}
