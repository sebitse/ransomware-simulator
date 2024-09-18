package com.simulator;

import com.simulator.command.Command;
import com.simulator.command.CommandFactory;
import com.simulator.keymanagement.KeyCache;
import com.simulator.keymanagement.KeyManager;

import java.io.File;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Objects;

public class DirectoryProcessor {
    private final KeyCache keyCache;

    public DirectoryProcessor() {
        this.keyCache = new KeyCache(KeyManager.getInstance());;
    }

    // Process a full directory
    public void processDirectory(File directory, int operation, String algorithm) throws Exception {
        if (directory == null || !directory.isDirectory()) {
            return;
        }

        // Recursively process all the subdirectories and files
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                // Recursively process subdirectories
                processDirectory(file, operation, algorithm);
            } else {
                // Process a file
                processSingleFile(file, operation, algorithm);
            }
        }
    }

    // Process a file
    public void processSingleFile(File file, int operation, String algorithm) throws Exception {
        Command command = null;

        if (algorithm.equalsIgnoreCase("AES")) {
            Key aesKey = keyCache.getAESKey();
            command = CommandFactory.createCommand(operation, "AES", aesKey, file);

        } else if (algorithm.equalsIgnoreCase("RSA")) {
            if (operation == 1) {
                PublicKey publicKey = keyCache.getRSAPublicKey();
                command = CommandFactory.createCommand(operation, "RSA", publicKey, file);
            } else if (operation == 2) {
                PrivateKey privateKey = keyCache.getRSAPrivateKey();
                command = CommandFactory.createCommand(operation, "RSA", privateKey, file);
            }
        }

        executeCommand(command);
    }

    // Execute the command (encrypt or decrypt)
    private void executeCommand(Command command) {
        if (command == null)
            return;

        command.start();
    }
}
