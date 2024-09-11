package com.simulator.keymanagement;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HashMap;

public class KeyManager {
    private static KeyManager instance;
    private SecretKey secretKey; // For symmetric algorithms (AES)
    private KeyPair keyPair;     // For asymmetric algorithms (RSA)

    // keys size dictionary
    private HashMap<String, Integer> dictionary;

    private static final int AESKeySize = 256;
    private static final int RSAKeySize = 2048;

    // private constructor to implement Singleton
    private KeyManager() {}


    public static synchronized KeyManager getInstance() {
        if(instance == null) {
            instance = new KeyManager();
        }
        return instance;
    }

    public void generateKey(String algorithm) throws Exception {
        switch (algorithm.toUpperCase()) {
            case "AES":
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(AESKeySize);
                this.secretKey = keyGen.generateKey();
                break;

            case "RSA":
                KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
                keyPairGen.initialize(RSAKeySize);
                this.keyPair = keyPairGen.generateKeyPair();
                break;

            default:
                throw new IllegalArgumentException("Unsupported algo for moment: " + algorithm);
        }
    }


    // Getters area
    public SecretKey getSecretKey() {
        return secretKey;
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }


}
