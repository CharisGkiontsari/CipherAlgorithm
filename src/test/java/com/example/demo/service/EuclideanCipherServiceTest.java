package com.example.demo.service;

import com.example.demo.service.impl.EuclideanCipherServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EuclideanCipherServiceTest {

    @InjectMocks
    private EuclideanCipherServiceImpl euclideanCipherService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEncrypt() {
        String message = "hello";
        int a = 5;
        int b = 8;
        String expected = "rclla";
        String result = euclideanCipherService.encrypt(message, a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testDecrypt() {
        String message = "rclla";
        int a = 5;
        int b = 8;
        String expected = "hello";
        String result = euclideanCipherService.decrypt(message, a, b);
        assertEquals(expected, result);
    }
}
