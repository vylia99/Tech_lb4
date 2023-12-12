package com.example.demo1711.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Named
@ApplicationScoped
public class MyDateTimeFormatter {
    public String dateFormat(LocalDateTime dt) {
        return dt.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }

    public String dateTimeFormat(LocalDateTime dt) {
        return dt.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm"));
    }
}
