package com.ragh.sportsProject.layers.web;

public class ErrorMessage {
    public ErrorMessage(String details) {
        this.details = details;
    }

    public String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
