package com.example.demo.service;

import com.example.demo.model.Beer;
import com.example.demo.repo.BeerRepository;
import org.springframework.stereotype.Component;

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
}
