package org.improving.crudmanager.repository;

import org.improving.crudmanager.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
