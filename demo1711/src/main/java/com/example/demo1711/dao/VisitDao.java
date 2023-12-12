package com.example.demo1711.dao;

import com.example.demo1711.data.Visit;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Stateless
public class VisitDao {
    @PersistenceContext
    EntityManager em;

    public Visit find(int id){
        return em.find(Visit.class, id);
    }

    public void add(Visit visit) {
        em.persist(visit);
    }
    public List<Object[]> getVisitsByDate(LocalDateTime dateTime) {
        LocalDateTime startOfDay = dateTime.with(LocalTime.MIN);
        LocalDateTime endOfDay = dateTime.with(LocalTime.MAX);

        return em.createQuery("SELECT v.id, v.dateTime, c.name, p.name, m.name " +
                        "FROM Visit v " +
                        "JOIN v.pet p " +
                        "JOIN p.client c " +
                        "JOIN v.medicalService m " +
                        "WHERE v.dateTime BETWEEN :startOfDay AND :endOfDay", Object[].class)
                .setParameter("startOfDay", startOfDay)
                .setParameter("endOfDay", endOfDay)
                .getResultList();
    }


}



