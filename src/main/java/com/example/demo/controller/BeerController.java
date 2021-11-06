package com.example.demo.controller;
import com.example.demo.model.Beer;
import com.example.demo.service.BeerService;
import com.example.demo.ui.BeerRequestModel;
import com.example.demo.ui.BeerResponseModel;
import org.apache.catalina.LifecycleState;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class BeerController {

    private BeerService beerService;
    private Environment environment;

    private ModelMapper modelMapper;
    public BeerController(BeerService beerService, Environment environment,ModelMapper modelMapper) {
        this.beerService = beerService;
        this.environment = environment;
        this.modelMapper=modelMapper;
    }

    @GetMapping
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("beer-app is up and runing on port "+environment.getProperty("local.server.port"));
    }
    @PostMapping("/beers")
    public ResponseEntity<BeerResponseModel> createBeer(@Valid @RequestBody BeerRequestModel beerRequestModel)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Beer beer=modelMapper.map(beerRequestModel,Beer.class);
        beer.setBeerId(UUID.randomUUID().toString());
       beer= beerService.createBeer(beer);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(beer,BeerResponseModel.class));

    }
    @GetMapping("/beers/{beerId}")
    public ResponseEntity<BeerResponseModel> getBeerByBeerId(@PathVariable("beerId") String beerId)
    {
        List<Beer> beerList=beerService.findByBeerId(beerId);
        if (beerList.isEmpty())
        {
            return ResponseEntity.status(400).build();
        }
        else
        {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(beerList.get(0),BeerResponseModel.class));
        }
    }




}
