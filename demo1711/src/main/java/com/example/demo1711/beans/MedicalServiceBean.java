package com.example.demo1711.beans;

import com.example.demo1711.dao.MedicalServiceDao;
import com.example.demo1711.data.Client;
import com.example.demo1711.data.MedicalService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Named
@SessionScoped
public class MedicalServiceBean implements Serializable {
    @EJB
    MedicalServiceDao medicalServiceDao;

    @Getter
    @Setter
    private MedicalService selectedMedicalService;



}
