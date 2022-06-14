package org.improving.crudmanager.rest;

import java.util.List;

import org.improving.crudmanager.models.Country;
import org.improving.crudmanager.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryRest {

  @Autowired
  private CountryService countryService;

  @GetMapping
  private ResponseEntity<List<Country>> getAllCountries() {
    return ResponseEntity.ok(countryService.findAll());
  }

}
