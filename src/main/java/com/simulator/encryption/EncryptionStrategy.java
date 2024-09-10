package com.simulator.encryption;

import javax.crypto.SecretKey;
import java.io.File;

public interface EncryptionStrategy {
    void encrypt(File file, SecretKey key) throws Exception;
    void decrypt(File file, SecretKey key) throws Exception;
}
