package com.example.demo1711.util;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.Serializable;

@Named
@ApplicationScoped
public class CommonUtils implements Serializable {
    private static final long serialVersionUID = 1L;

    public void redirectWithGet() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();

        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();

        if (queryString != null) {
            requestURL.append('?').append(queryString);
        }

        String url = requestURL.toString();
        try {
            externalContext.redirect(requestURL.toString());
        } catch (IOException e) {
            throw new RuntimeException("Unable to redirect to " + url);
        }

        facesContext.responseComplete();
    }
}