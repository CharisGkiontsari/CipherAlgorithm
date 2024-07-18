package com.example.demo.service.impl;

import com.example.demo.service.CaesarCipherService;
import com.example.demo.util.CipherUtil;
import org.springframework.stereotype.Service;

@Service
public class CaesarCipherServiceImpl implements CaesarCipherService {

    @Override
    public String encrypt(String message, int shift) {
        return CipherUtil.caesarCipher(message, shift);
    }

    @Override
    public String decrypt(String message, int shift) {
        return CipherUtil.caesarCipher(message, 26 - shift);
    }
}
