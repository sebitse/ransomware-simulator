package com.simulator.keymanagement;

import javax.crypto.SecretKey;
import java.security.KeyPair;

public class KeyManager {
    private static KeyManager instance;
    private SecretKey secretKey; // For symmetric algorithms (AES)
    private KeyPair keyPair;     // For asymmetric algorithms (RSA)

    // private constructor to implement Singleton
    private KeyManager() {}


    public static synchronized KeyManager getInstance() {
        if(instance == null) {
            instance = new KeyManager();
        }
        return instance;
    }


    // Getters area
    public SecretKey getSecretKey() {
        return secretKey;
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }
}
