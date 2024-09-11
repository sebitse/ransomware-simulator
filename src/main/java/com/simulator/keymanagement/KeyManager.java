package com.simulator.keymanagement;

import javax.crypto.SecretKey;
import java.security.KeyPair;


public class KeyManager {
    private static KeyManager instance;
    private SecretKey secretKey;  // For symmetric algorithms (AES)
    private KeyPair keyPair;      // For asymmetric algorithms (RSA)
    private final AlgorithmRegistry algorithmRegistry = new AlgorithmRegistry();
    private final KeyGeneratorFactory keyGeneratorFactory = new KeyGeneratorFactory();

    private KeyManager() {}

    public static synchronized KeyManager getInstance() {
        if (instance == null) {
            instance = new KeyManager();
        }
        return instance;
    }

    // Method to generate a key based on the algorithm
    public void generateKey(String algorithm) throws Exception {
        if (!algorithmRegistry.isSupported(algorithm)) {
            throw new IllegalArgumentException("Unsupported algorithm: " + algorithm);
        }

        int keySize = algorithmRegistry.getKeySize(algorithm);
        Object generatedKey = keyGeneratorFactory.generateKey(algorithm, keySize);

        // Store the key appropriately based on the algorithm
        if (generatedKey instanceof SecretKey) {
            this.secretKey = (SecretKey) generatedKey;
        } else if (generatedKey instanceof KeyPair) {
            this.keyPair = (KeyPair) generatedKey;
        }
    }

    // Getters area
    public SecretKey getSecretKey() {
        return secretKey;
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }

    // add algorithms to the registry
    public void addAlgorithm(String algorithm, int keySize) {
        algorithmRegistry.addAlgorithm(algorithm, keySize);
    }
}
