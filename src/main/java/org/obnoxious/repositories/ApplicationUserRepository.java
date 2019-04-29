package org.obnoxious.repositories;

import org.obnoxious.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
