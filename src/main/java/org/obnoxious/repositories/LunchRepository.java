package org.obnoxious.repositories;

        import org.obnoxious.entities.Lunch;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.data.repository.query.Param;

        import java.util.List;

public interface LunchRepository extends CrudRepository<Lunch, Long> {

    @Query(value = "select a from Lunch a where a.aPackage.apackageId = :packageId")
    List<Lunch> findByPackageId(@Param("packageId") Long packageId);

}

