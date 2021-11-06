package com.example.demo.service;

import com.example.demo.model.Beer;

import java.util.List;

public interface BeerService {
    public Beer createBeer(Beer beer);
    public List<Beer> findByBeerId(String beerId);
}
