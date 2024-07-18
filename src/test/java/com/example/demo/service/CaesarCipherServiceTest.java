package com.example.demo.service;

import com.example.demo.service.impl.CaesarCipherServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCipherServiceTest {

    @InjectMocks
    private CaesarCipherServiceImpl caesarCipherService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEncrypt() {
        String message = "hello";
        int shift = 3;
        String expected = "khoor";
        String result = caesarCipherService.encrypt(message, shift);
        assertEquals(expected, result);
    }

    @Test
    public void testDecrypt() {
        String message = "khoor";
        int shift = 3;
        String expected = "hello";
        String result = caesarCipherService.decrypt(message, shift);
        assertEquals(expected, result);
    }
}
