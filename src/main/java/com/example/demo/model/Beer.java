package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beer {
    @Column(name = "beer_d",unique = true)
    private String beerId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "beer_name",nullable = false,unique = true)
    private  String beerName;
    @Column(name = "unit_cost",nullable = false)
    private Double ratePerUnit;

    public Beer(String beerId, String beerName, Double ratePerUnit) {
        this.beerId = beerId;
        this.beerName = beerName;
        this.ratePerUnit = ratePerUnit;
    }
}
