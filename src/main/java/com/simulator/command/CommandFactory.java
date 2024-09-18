package com.simulator.command;

import com.simulator.encryption.EncryptionFactory;
import com.simulator.encryption.EncryptionStrategy;
import com.simulator.fileprocessing.ObservableDecryptFileProcessor;
import com.simulator.fileprocessing.ObservableEncryptFileProcessor;

import java.io.File;
import java.security.Key;

public class CommandFactory {
    public static Command createCommand(int operation, String algorithm, Key key, File file) {
        EncryptionStrategy encryptionStrategy = EncryptionFactory.getEncryptionStrategy(algorithm);

        if (operation == 1) {
            ObservableEncryptFileProcessor processor = new ObservableEncryptFileProcessor(encryptionStrategy, key);
            return new EncryptCommand(processor, file);
        } else if (operation == 2) {
            ObservableDecryptFileProcessor processor = new ObservableDecryptFileProcessor(encryptionStrategy, key);
            return  new DecryptCommand(processor, file);
        }

        return null;
    }
}
