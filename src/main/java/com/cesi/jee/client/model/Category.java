package com.cesi.jee.client.model;

import java.util.ArrayList;
import java.util.List;


public class Category {

  private Long id;

  private String name;

  private List<Website> websites;

  public List<Website> getWebsites() {
    return this.websites;
  }

  public void setWebsites(List<Website> websites) {
    this.websites = websites;
  }

  public Category() {
    this.websites = new ArrayList<>();
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public Category setName(String name) {
    this.name = name;
    return this;
  }
}