package com.TradeMap.desafiobackend.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BlogRequestDTO {

    private String title;
    private String description;
    private String body;
    private LocalDate created_at;
    private LocalDate updated_at;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getCreated_at() {
        return LocalDate.now();
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return LocalDate.now();
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "BlogRequestDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }


}
