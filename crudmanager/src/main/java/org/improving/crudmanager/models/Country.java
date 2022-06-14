package org.improving.crudmanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "countries")
public @Data class Country {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  public Country() {
  }

  public Country(String name) {
    this.name = name;
  }

  public Country(Long id, String name) {
    this.id = id;
    this.name = name;
  }

}
