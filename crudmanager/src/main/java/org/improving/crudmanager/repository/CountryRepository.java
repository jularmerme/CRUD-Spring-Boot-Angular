package org.improving.crudmanager.repository;

import org.improving.crudmanager.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
