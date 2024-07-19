package com.example.demo.controller;

import com.example.demo.service.EuclideanCipherService;
import com.example.demo.service.CaesarCipherService;
import com.example.demo.service.impl.CaesarCipherServiceImpl;
import com.example.demo.service.impl.EuclideanCipherServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CaesarCipherController.class)
@Import({EuclideanCipherServiceImpl.class, CaesarCipherServiceImpl.class})
public class EuclideanCipherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EuclideanCipherService euclideanCipherService;

    @MockBean
    private CaesarCipherService caesarCipherService;

    @Test
    public void testEuclideanEncrypt() throws Exception {
        String message = "hello";
        int a = 5;
        int b = 8;
        String encryptedMessage = "rclla";

        when(euclideanCipherService.encrypt(message, a, b)).thenReturn(encryptedMessage);

        mockMvc.perform(post("/api/euclidean/encrypt")
                        .contentType("application/json")
                        .content("{\"message\": \"hello\", \"a\": 5, \"b\": 8}"))
                .andExpect(status().isOk())
                .andExpect(content().string(encryptedMessage));
    }

    @Test
    public void testEuclideanDecrypt() throws Exception {
        String message = "rclla";
        int a = 5;
        int b = 8;
        String decryptedMessage = "hello";

        when(euclideanCipherService.decrypt(message, a, b)).thenReturn(decryptedMessage);

        mockMvc.perform(post("/api/euclidean/decrypt")
                        .contentType("application/json")
                        .content("{\"message\": \"rclla\", \"a\": 5, \"b\": 8}"))
                .andExpect(status().isOk())
                .andExpect(content().string(decryptedMessage));
    }
}
