package com.example.demo.model;


import org.springframework.stereotype.Component;

@Component
public class ContactMessage {
    private String suject;
    private String email;
    private String message;

    public ContactMessage(String suject, String email, String message) {
        this.suject = suject;
        this.email = email;
        this.message = message;
    }

    public ContactMessage() {}

    public String getSuject() {
        return suject;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public void setSuject(String suject) {
        this.suject = suject;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
