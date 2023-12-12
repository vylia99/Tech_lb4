package com.example.demo1711.dao;

import com.example.demo1711.data.MedicalService;
import com.example.demo1711.data.Pet;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class MedicalServiceDao {
    @PersistenceContext
    EntityManager em;

    public MedicalService find(int id){
        return em.find(MedicalService.class, id);
    }
    public List<MedicalService> findAll(){
        return em.createNamedQuery("MedicalService.findAll", MedicalService.class).getResultList();
    }
    public MedicalService findByName(String name) {
        return em.createNamedQuery("MedicalService.findByNameIgnoreCase", MedicalService.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public void add(MedicalService medicalService) {
        em.persist(medicalService);
    }
}
