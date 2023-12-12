package com.example.demo1711.beans;

import com.example.demo1711.dao.MedicalServiceDao;
import com.example.demo1711.dao.PetDao;
import com.example.demo1711.dao.VisitDao;
import com.example.demo1711.data.MedicalService;
import com.example.demo1711.data.Pet;
import com.example.demo1711.data.Visit;
import com.example.demo1711.util.CommonUtils;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class PetBean implements Serializable {
    @Getter @Setter
    private Pet currentPet;


    @Getter    @Setter
    private Pet pet = new Pet();

    @Getter    @Setter
    private Visit visitForAdd = new Visit();
    @Getter    @Setter
    private String medicalServiceStr = "";


    @Inject
    CommonUtils utils;

    @EJB
    PetDao petDao;
    @EJB
    VisitDao visitDao;
    @EJB
    MedicalServiceDao medicalServiceDao;


    public String showVisit(int petId) {
        currentPet = petDao.find(petId);
        return "pet";
    }

    public void add() {
        petDao.add(pet);
        pet = new Pet();
    }
    public void addVisit() {
        visitForAdd.setMedicalService(medicalServiceDao.findByName(medicalServiceStr));
        visitForAdd.setPet(currentPet);
        visitDao.add(visitForAdd);

        currentPet = petDao.find(currentPet.getId());
        currentPet.getVisits().add(visitForAdd);
        visitForAdd = new Visit();
        utils.redirectWithGet();
    }

    public List<MedicalService> completeMedText(String query) {
        String queryLowerCase = query.toLowerCase();
        List<MedicalService> kindsList = medicalServiceDao.findAll();

        return kindsList.stream().filter(t -> t.getName().toLowerCase().startsWith(queryLowerCase)).toList();
    }
}
