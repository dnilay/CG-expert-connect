package com.example.demo.controller;
import com.example.demo.model.Beer;
import com.example.demo.service.BeerService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BeerController {

    private BeerService beerService;
    private Environment environment;

    public BeerController(BeerService beerService, Environment environment) {
        this.beerService = beerService;
        this.environment = environment;
    }

    @GetMapping
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("beer-app is up and runing on port "+environment.getProperty("local.server.port"));
    }
    @PostMapping("/beers")
    public ResponseEntity<Beer> createBeer(@RequestBody Beer beer)
    {
        beer.setBeerId(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(beerService.createBeer(beer));

    }



}
