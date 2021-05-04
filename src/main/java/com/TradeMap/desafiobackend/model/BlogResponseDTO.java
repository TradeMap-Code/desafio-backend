package com.TradeMap.desafiobackend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class BlogResponseDTO {

    private String message;
    private LocalDate date;
    private UUID id;

    public BlogResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


}
