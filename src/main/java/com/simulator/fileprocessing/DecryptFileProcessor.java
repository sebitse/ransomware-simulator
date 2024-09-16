package com.simulator.fileprocessing;

import com.simulator.encryption.EncryptionStrategy;

import java.io.File;
import java.security.Key;

public class DecryptFileProcessor extends FileProcessor {
    private final EncryptionStrategy encryptionStrategy;
    private final Key key;

    public DecryptFileProcessor(EncryptionStrategy encryptionStrategy, Key key) {
        this.encryptionStrategy = encryptionStrategy;
        this.key = key;
    }

    @Override
    protected void transformFile(File file) {
        try {
            encryptionStrategy.decrypt(file, key);
            System.out.println("File decrypted: " + file.getName());
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
