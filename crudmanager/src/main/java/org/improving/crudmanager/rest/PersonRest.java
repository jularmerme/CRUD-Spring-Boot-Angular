package org.improving.crudmanager.rest;

import java.net.URI;
import java.util.List;

import org.improving.crudmanager.models.Person;
import org.improving.crudmanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonRest {

  @Autowired
  private PersonService personService;

  @GetMapping
  private ResponseEntity<List<Person>> getAllPersons() {
    return ResponseEntity.ok(personService.findAll());
  }

  private ResponseEntity<Person> savePerson(@RequestBody Person person) {
    try {
      Person savedPerson = personService.save(person);
      return ResponseEntity.created(new URI("/person/" + savedPerson.getId())).body(savedPerson);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

}
