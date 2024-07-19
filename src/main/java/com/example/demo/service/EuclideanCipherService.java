package com.example.demo.service;

public interface EuclideanCipherService {
    String encrypt(String message, int a, int b);
    String decrypt(String message, int a, int b);
}
