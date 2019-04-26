package org.obnoxious.repositories;

import org.obnoxious.entities.Dinner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DinnerRepository extends CrudRepository<Dinner, Long> {

    @Query(value = "select a from Dinner a where a.aPackage.apackageId = :packageId")
    List<Dinner> findByPackageId(@Param("packageId") Long packageId);

}
