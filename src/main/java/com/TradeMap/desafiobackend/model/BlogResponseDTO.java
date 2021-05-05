package com.TradeMap.desafiobackend.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BlogResponseDTO {

    private String message;
    private LocalDateTime date;

    public BlogResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return dateTimePattern(LocalDateTime.now());
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public static String dateTimePattern(LocalDateTime received) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        String inThePattern = formatter.format(received);

        return inThePattern;
    }



}
