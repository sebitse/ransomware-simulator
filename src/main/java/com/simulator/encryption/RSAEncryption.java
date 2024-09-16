package com.simulator.encryption;


import javax.crypto.Cipher;
import java.io.File;
import java.nio.file.Files;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAEncryption implements EncryptionStrategy {

    final static String algorithmUsed = "RSA";

    @Override
    public void encrypt(File file, Key key) throws Exception {
        // Ensure the key is a PublicKey for encryption
        if (!(key instanceof PublicKey)) {
            throw new IllegalArgumentException("Invalid key type for RSA encryption. Expected PublicKey.");
        }

        Cipher cipher = Cipher.getInstance(algorithmUsed);
        cipher.init(Cipher.ENCRYPT_MODE, key);  // Use the public key to encrypt

        byte[] fileBytes = Files.readAllBytes(file.toPath());
        byte[] encryptedBytes = cipher.doFinal(fileBytes);
        Files.write(file.toPath(), encryptedBytes);  // Save encrypted bytes back to the file
    }

    @Override
    public void decrypt(File file, Key key) throws Exception {
        // Ensure the key is a PrivateKey for decryption
        if (!(key instanceof PrivateKey)) {
            throw new IllegalArgumentException("Invalid key type for RSA decryption. Expected PrivateKey.");
        }

        Cipher cipher = Cipher.getInstance(algorithmUsed);
        cipher.init(Cipher.DECRYPT_MODE, key);  // Use the private key to decrypt

        byte[] fileBytes = Files.readAllBytes(file.toPath());
        byte[] decryptedBytes = cipher.doFinal(fileBytes);
        Files.write(file.toPath(), decryptedBytes);  // save decrypted bytes
    }
}
