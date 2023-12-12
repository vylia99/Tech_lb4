package com.example.demo1711.dao;

import com.example.demo1711.data.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ClientDao {
    @PersistenceContext
    EntityManager em;

    public List<Client> findAll() {
        return em.createNamedQuery("Client.findAll", Client.class).getResultList();
    }
    public List<Object[]> getClientsByPetKind(String petKind) {
        return em.createQuery("SELECT c.id, c.name " +
                        "FROM Client c " +
                        "JOIN c.pets p " +
                        "WHERE p.kind = :petKind", Object[].class)
                .setParameter("petKind", petKind)
                .getResultList();
    }

    public void add(Client client) {
        em.persist(client);
    }

    public void delete(int id) {
        Client client = em.find(Client.class, id);
        em.remove(client);
    }

    public Client find(int clientId) {
        return em.find(Client.class, clientId);
    }

    public void update(Client client) {
        em.merge(client);
    }
}
