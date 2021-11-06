package com.example.demo.service;

import com.example.demo.model.Beer;
import com.example.demo.repo.BeerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "beerService")
public class BeerServiceImpl implements BeerService{

    private BeerRepository beerRepository;

    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public Beer createBeer(Beer beer) {
        return beerRepository.createBeer(beer);
    }

    @Override
    public List<Beer> findByBeerId(String beerId) {
        return beerRepository.findByBeerId(beerId);
    }
}
