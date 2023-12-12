package com.example.demo1711.beans;

import com.example.demo1711.dao.VisitDao;
import com.example.demo1711.data.Visit;
import com.example.demo1711.util.CommonUtils;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Named
@SessionScoped
public class VisitBean implements Serializable {
    @EJB
    VisitDao visitDao;
    @Getter @Setter
    private LocalDateTime selectedDate;
    @Getter @Setter
    private Visit visit = new Visit();
    @Getter @Setter
    private List<Object[]> visits;
    @Inject
    CommonUtils utils;

    public void findVisitsByDate() {
        if (selectedDate != null) {
            visits = visitDao.getVisitsByDate(selectedDate);
        } else {
        }
        utils.redirectWithGet();
    }

    public void add(){
        visitDao.add(visit);
        visit = new Visit();
    }
}
