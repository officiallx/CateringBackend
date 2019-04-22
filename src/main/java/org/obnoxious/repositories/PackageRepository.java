package org.obnoxious.repositories;

import org.obnoxious.entities.Package;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PackageRepository extends CrudRepository<Package, Long> {

    public List<Package> findByEvent_EventId(Long eventId);
}
