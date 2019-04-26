package org.obnoxious.repositories;

import org.obnoxious.entities.Breakfast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BreakfastRepository extends CrudRepository<Breakfast, Long> {

    @Query(value = "select a from Breakfast a where a.aPackage.apackageId = :packageId")
    List<Breakfast> findByPackageId(@Param("packageId") Long packageId);

}
