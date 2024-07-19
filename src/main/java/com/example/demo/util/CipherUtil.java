package com.example.demo.util;

public class CipherUtil {

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                result.append((char) ((character - base + shift) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static String euclideanEncrypt(String text, int a, int b) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                result.append((char) (((a * (character - base) + b) % 26) + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static String euclideanDecrypt(String text, int a, int b) {
        StringBuilder result = new StringBuilder();
        int a_inv = 0;
        int flag = 0;
        for (int i = 0; i < 26; i++) {
            flag = (a * i) % 26;
            if (flag == 1) {
                a_inv = i;
                break;
            }
        }
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                result.append((char) (((a_inv * ((character - base - b + 26)) % 26)) + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
