package com.example.demo.repo;

import com.example.demo.model.Beer;

import java.util.List;

public interface BeerRepository {

    public Beer createBeer(Beer beer);
    public List<Beer> findByBeerId(String beerId);
}
