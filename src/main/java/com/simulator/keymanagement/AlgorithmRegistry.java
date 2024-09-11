package com.simulator.keymanagement;

import java.util.HashMap;
import java.util.Map;

public class AlgorithmRegistry {
    private final Map<String, Integer> keySizes;

    public AlgorithmRegistry() {
        keySizes = new HashMap<>();

        keySizes.put("AES", 256); // Default 256-bit AES
        keySizes.put("RSA", 2048);
    }

    // Method to add or update an algorithm and key size
    public void addAlgorithm(String algorithm, int keySize) {
        keySizes.put(algorithm.toUpperCase(), keySize);
    }

    public int getKeySize(String algorithm) {
        String algo = algorithm.toUpperCase();

        if (keySizes.containsKey(algo)) {
            return keySizes.get(algo);
        }
        return -1; // algorithm not found
    }

    // Check if the algorithm is supported
    public boolean isSupported(String algorithm) {
        return keySizes.containsKey(algorithm.toUpperCase());
    }
}
