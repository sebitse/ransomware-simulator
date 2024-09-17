package com.simulator.keymanagement;

import javax.crypto.SecretKey;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;


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

    // Return the PublicKey for asymmetric algo
    public PublicKey getPublicKey() {
        if (this.keyPair == null) {
            throw new IllegalStateException("KeyPair has not been generated.");
        }
        return this.keyPair.getPublic();
    }

    // Return the PrivateKey for asymmetric algo
    public PrivateKey getPrivateKey() {
        if (this.keyPair == null) {
            throw new IllegalStateException("KeyPair has not been generated.");
        }
        return this.keyPair.getPrivate();
    }

    // add algorithms to the registry
    public void addAlgorithm(String algorithm, int keySize) {
        algorithmRegistry.addAlgorithm(algorithm, keySize);
    }
}
