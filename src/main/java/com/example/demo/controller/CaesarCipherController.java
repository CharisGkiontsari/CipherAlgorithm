package com.example.demo.controller;

import com.example.demo.model.EncryptRequest;
import com.example.demo.model.DecryptRequest;
import com.example.demo.service.CaesarCipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CaesarCipherController {

    @Autowired
    private CaesarCipherService caesarCipherService;

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody EncryptRequest request) {
        return caesarCipherService.encrypt(request.getMessage(), request.getShift());
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody DecryptRequest request) {
        return caesarCipherService.decrypt(request.getMessage(), request.getShift());
    }
}
