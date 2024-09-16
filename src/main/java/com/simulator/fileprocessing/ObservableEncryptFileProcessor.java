package com.simulator.fileprocessing;

import com.simulator.encryption.EncryptionStrategy;


import java.io.File;
import java.security.Key;

public class ObservableEncryptFileProcessor extends ObservableFileProcessor {
    private final EncryptionStrategy encryptionStrategy;
    private final Key key;

    public ObservableEncryptFileProcessor(EncryptionStrategy encryptionStrategy, Key key) {
        this.encryptionStrategy = encryptionStrategy;
        this.key = key;
    }

    @Override
    protected void transformFile(File file) {
        try {
            encryptionStrategy.encrypt(file, key);
            System.out.println("File encrypted: " + file.getName());

            notify("File encrypted " + file.getName());
        } catch (Exception e) {
            System.err.println("Error encrypting file: " + file.getName());
            System.err.println(e.toString());
        }
    }
}
