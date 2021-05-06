package com.TradeMap.desafiobackend.dto;

import com.TradeMap.desafiobackend.controller.BlogController;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class BlogResponseDTO {

    private String message;
    private LocalDateTime date;
    private String id;

    BlogController blogController = new BlogController();

    public BlogResponseDTO(String message, String id) {
        this.message = message;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String dateTimePattern(LocalDateTime received) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        String inThePattern = formatter.format(received);

        return inThePattern;
    }



}
