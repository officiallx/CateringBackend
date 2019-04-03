package org.obnoxious.repositories;

import org.obnoxious.entities.Staff;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Staff, Long> {
}
