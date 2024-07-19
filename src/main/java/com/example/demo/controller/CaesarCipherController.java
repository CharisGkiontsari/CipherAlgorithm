package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.CaesarCipherService;
import com.example.demo.service.EuclideanCipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CaesarCipherController {

    @Autowired
    private CaesarCipherService caesarCipherService;

    @Autowired
    private EuclideanCipherService euclideanCipherService;

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody EncryptRequest request) {
        return caesarCipherService.encrypt(request.getMessage(), request.getShift());
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody DecryptRequest request) {
        return caesarCipherService.decrypt(request.getMessage(), request.getShift());
    }

    @PostMapping("/euclidean/encrypt")
    public String euclideanEncrypt(@RequestBody EuclideanEncryptRequest request) {
        return euclideanCipherService.encrypt(request.getMessage(), request.getA(), request.getB());
    }

    @PostMapping("/euclidean/decrypt")
    public String euclideanDecrypt(@RequestBody EuclideanDecryptRequest request) {
        return euclideanCipherService.decrypt(request.getMessage(), request.getA(), request.getB());
    }
}
