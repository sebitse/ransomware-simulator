package com.simulator.encryption;


import java.io.File;
import java.security.Key;

public interface EncryptionStrategy {
    void encrypt(File file, Key key) throws Exception;
    void decrypt(File file, Key key) throws Exception;
}
