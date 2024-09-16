package com.simulator.command;

import com.simulator.fileprocessing.FileProcessor;

import java.io.File;

public class DecryptCommand implements Command {
    private final FileProcessor fileProcessor;
    private final File file;

    public DecryptCommand(FileProcessor fileProcessor, File file) {
        this.fileProcessor = fileProcessor;
        this.file = file;
    }

    // execute the method to start the decryption process
    @Override
    public void start() {
        fileProcessor.processFile(file);
    }
}
