package com.example.demo;

import com.example.demo.model.Beer;
import com.example.demo.repo.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class MyAppApplication implements CommandLineRunner {

    private BeerRepository beerRepository;

    @Autowired
    public MyAppApplication(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        beerRepository.createBeer(new Beer(UUID.randomUUID().toString(),"Beer-1",12.0));
        beerRepository.createBeer(new Beer(UUID.randomUUID().toString(),"Beer-2",13.0));
        beerRepository.createBeer(new Beer(UUID.randomUUID().toString(),"Beer-3",14.0));
        beerRepository.createBeer(new Beer(UUID.randomUUID().toString(),"Beer-4",16.0));
    }
}
