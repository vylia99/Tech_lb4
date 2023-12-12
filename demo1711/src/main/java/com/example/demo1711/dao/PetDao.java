package com.example.demo1711.dao;

import com.example.demo1711.data.Client;
import com.example.demo1711.data.Pet;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PetDao {
    @PersistenceContext
    EntityManager em;

    public Pet find(int id){
        return em.find(Pet.class, id);
    }
    public void add(Pet pet) {
        em.persist(pet);
    }
}
