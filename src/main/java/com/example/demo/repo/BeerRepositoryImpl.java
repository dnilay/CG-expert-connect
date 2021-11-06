package com.example.demo.repo;

import com.example.demo.model.Beer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component(value = "beerRepository")
@EnableTransactionManagement
public class BeerRepositoryImpl implements BeerRepository {

    private EntityManager entityManager;

    @Autowired
    public BeerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Beer createBeer(Beer beer) {
        Session session = entityManager.unwrap(Session.class);
        session.save(beer);
        return beer;
    }

    @Override
    @Transactional
    public List<Beer> findByBeerId(String beerId) {
        Query query= entityManager.createQuery("SELECT B FROM Beer B where B.beerId=:bId",Beer.class);
        query.setParameter("bId",beerId);
        return query.getResultList();
    }
}
