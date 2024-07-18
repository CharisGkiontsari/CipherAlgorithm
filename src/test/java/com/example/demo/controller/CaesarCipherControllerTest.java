package com.example.demo.controller;

import com.example.demo.service.CaesarCipherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CaesarCipherController.class)
public class CaesarCipherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CaesarCipherService caesarCipherService;

    @Test
    public void testEncrypt() throws Exception {
        String message = "hello";
        int shift = 3;
        String encryptedMessage = "khoor";

        when(caesarCipherService.encrypt(message, shift)).thenReturn(encryptedMessage);

        mockMvc.perform(post("/api/encrypt")
                        .contentType("application/json")
                        .content("{\"message\": \"hello\", \"shift\": 3}"))
                .andExpect(status().isOk())
                .andExpect(content().string(encryptedMessage));
    }

    @Test
    public void testDecrypt() throws Exception {
        String message = "khoor";
        int shift = 3;
        String decryptedMessage = "hello";

        when(caesarCipherService.decrypt(message, shift)).thenReturn(decryptedMessage);

        mockMvc.perform(post("/api/decrypt")
                        .contentType("application/json")
                        .content("{\"message\": \"khoor\", \"shift\": 3}"))
                .andExpect(status().isOk())
                .andExpect(content().string(decryptedMessage));
    }
}
