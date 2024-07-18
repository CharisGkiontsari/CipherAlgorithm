package com.example.demo.service;

public interface CaesarCipherService {
    String encrypt(String message, int shift);
    String decrypt(String message, int shift);
}
