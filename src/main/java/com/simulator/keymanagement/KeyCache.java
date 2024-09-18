package com.simulator.keymanagement;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyCache {
    private Key aesKey;
    private PublicKey rsaPublicKey;
    private PrivateKey rsaPrivateKey;
    private final KeyManager keyManager;

    public KeyCache(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public Key getAESKey() throws Exception {
        if (aesKey == null) {
            keyManager.generateKey("AES");
            aesKey = keyManager.getSecretKey();
            System.out.println("New AES key generated.");
        } else {
            System.out.println("Using previously generated AES key.");
        }
        return aesKey;
    }

    public PublicKey getRSAPublicKey() throws Exception {
        if (rsaPublicKey == null) {
            keyManager.generateKey("RSA");
            rsaPublicKey = keyManager.getPublicKey();
            rsaPrivateKey = keyManager.getPrivateKey(); // Generate both keys
            System.out.println("New RSA key pair generated.");
        } else {
            System.out.println("Using previously generated RSA key pair.");
        }
        return rsaPublicKey;
    }

    public PrivateKey getRSAPrivateKey() throws Exception {
        if (rsaPrivateKey == null) {
            getRSAPublicKey();  // both keys are generated
        }
        return rsaPrivateKey;
    }
}
