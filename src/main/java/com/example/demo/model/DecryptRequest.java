package com.example.demo.model;

public class DecryptRequest {
    private String message;
    private int shift;

    // Default constructor
    public DecryptRequest() {
    }

    // Constructor with parameters
    public DecryptRequest(String message, int shift) {
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
