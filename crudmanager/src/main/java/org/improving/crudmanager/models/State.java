package org.improving.crudmanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "states")
public @Data class State {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "country_id")
  private Country country;

  public State() {
  }

  public State(String name, Country country) {
    this.name = name;
    this.country = country;
  }

  public State(Long id, String name, Country country) {
    this.id = id;
    this.name = name;
    this.country = country;
  }

}
