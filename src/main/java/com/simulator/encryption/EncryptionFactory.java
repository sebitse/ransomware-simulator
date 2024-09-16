package com.simulator.encryption;

public class EncryptionFactory {

    public static EncryptionStrategy getEncryptionStrategy(String algorithm) throws IllegalArgumentException {
        switch (algorithm.toUpperCase()) {
            case "AES":
                return new AESEncyption();  // Return an AES encryption strategy
            case "RSA":
                return new RSAEncryption();  // Return an RSA encryption strategy
            default:
                throw new IllegalArgumentException("Unsupported encryption algorithm: " + algorithm);
        }
    }
}
