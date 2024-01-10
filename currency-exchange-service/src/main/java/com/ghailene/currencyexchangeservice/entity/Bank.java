package com.ghailene.currencyexchangeservice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<Country> countryList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public Bank(Long id, String name, List<Country> countryList) {
        this.id = id;
        this.name = name;
        this.countryList = countryList;
    }

    public Bank() {
    }
}

