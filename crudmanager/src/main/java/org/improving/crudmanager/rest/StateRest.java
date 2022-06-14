package org.improving.crudmanager.rest;

import java.util.List;

import org.improving.crudmanager.models.State;
import org.improving.crudmanager.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/states")
public class StateRest {

  @Autowired
  private StateService stateService;

  @GetMapping
  private ResponseEntity<List<State>> getAllStates() {
    return ResponseEntity.ok(stateService.findAll());
  }

  @GetMapping("{id}")
  private ResponseEntity<List<State>> getAllStatesByCountry(@PathVariable("id") Long countryId) {
    return ResponseEntity.ok(stateService.findAllByCountry(countryId));
  }

}
