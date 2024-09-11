package com.simulator.keymanagement;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class AsymmetricKeyGenerator {

    public KeyPair generateRSAKey(int keySize) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(keySize);

        return keyPairGen.generateKeyPair();
    }
}
