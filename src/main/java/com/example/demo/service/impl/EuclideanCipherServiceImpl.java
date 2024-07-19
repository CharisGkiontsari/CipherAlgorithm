package com.example.demo.service.impl;

import com.example.demo.service.EuclideanCipherService;
import com.example.demo.util.CipherUtil;
import org.springframework.stereotype.Service;

@Service
public class EuclideanCipherServiceImpl implements EuclideanCipherService {

    @Override
    public String encrypt(String message, int a, int b) {
        return CipherUtil.euclideanEncrypt(message, a, b);
    }

    @Override
    public String decrypt(String message, int a, int b) {
        return CipherUtil.euclideanDecrypt(message, a, b);
    }
}
