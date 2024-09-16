package com.simulator.command;

import com.simulator.fileprocessing.FileProcessor;

import java.io.File;

public class EncryptCommand implements Command {
    private final FileProcessor fileProcessor;
    private final File file;

    public EncryptCommand(FileProcessor fileProcessor, File file) {
        this.fileProcessor = fileProcessor;
        this.file = file;
    }

    // execute the method top start the encryption process
    @Override
    public void start() {
        fileProcessor.processFile(file);
    }
}
