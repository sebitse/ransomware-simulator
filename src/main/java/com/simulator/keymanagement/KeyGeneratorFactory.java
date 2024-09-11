package com.simulator.keymanagement;

public class KeyGeneratorFactory {
    private final SymmetricKeyGenerator symmetricKeyGenerator = new SymmetricKeyGenerator();
    private final AsymmetricKeyGenerator asymmetricKeyGenerator = new AsymmetricKeyGenerator();

    // return a key based on the algo and keySize
    public Object generateKey(String algorithm, int keySize) throws Exception {
        return switch (algorithm.toUpperCase()) {
            case "AES" -> symmetricKeyGenerator.generateAESKey(keySize);
            case "RSA" -> asymmetricKeyGenerator.generateRSAKey(keySize);
            default -> throw new IllegalArgumentException("Unsupported algo for moment: " + algorithm);
        };
    }
}
