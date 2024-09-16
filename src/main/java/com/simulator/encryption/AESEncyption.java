package com.simulator.encryption;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.File;
import java.nio.file.Files;
import java.security.Key;

public class AESEncyption implements EncryptionStrategy {

    final static String algorithmUsed = "AES";

    @Override
    public void encrypt(File file, Key key) throws Exception {
        // Test the key
        if(!(key instanceof SecretKey)) {
            throw new IllegalArgumentException("Invalid key for AES encryption");
        }

        Cipher cipher = Cipher.getInstance(algorithmUsed);
        cipher.init(Cipher.ENCRYPT_MODE, key);  // Initialize cipher

        byte[] fileBytes = Files.readAllBytes(file.toPath());   // Read
        byte[] encryptedBytes = cipher.doFinal(fileBytes);      // Encrypt
        Files.write(file.toPath(), encryptedBytes);             // Save back
    }

    @Override
    public void decrypt(File file, Key key) throws Exception {
        // Test the key
        if(!(key instanceof SecretKey)) {
            throw new IllegalArgumentException("Invalid key for AES encryption");
        }

        Cipher cipher = Cipher.getInstance(algorithmUsed);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] fileBytes = Files.readAllBytes(file.toPath());   // Read
        byte[] decryptedBytes = cipher.doFinal(fileBytes);      // Decrypt
        Files.write(file.toPath(), decryptedBytes);             // Save back
    }
}
