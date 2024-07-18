package com.example.demo.model;

public class EncryptRequest {
    private String message;
    private int shift;

    // Default constructor
    public EncryptRequest() {
    }

    // Constructor with parameters
    public EncryptRequest(String message, int shift) {
        this.message = message;
        this.shift = shift;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }
}
