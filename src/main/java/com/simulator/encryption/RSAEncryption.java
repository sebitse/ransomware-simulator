package com.simulator.encryption;

import javax.crypto.SecretKey;
import java.io.File;

public class RSAEncryption implements EncryptionStrategy {

    final static String algorithmUsed = "RSA";

    @Override
    public void encrypt(File file, SecretKey key) throws Exception {

    }

    @Override
    public void decrypt(File file, SecretKey key) throws Exception {

    }
}
