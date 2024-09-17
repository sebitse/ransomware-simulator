package com.simulator.command;

import com.simulator.fileprocessing.FileProcessor;
import com.simulator.fileprocessing.ObservableEncryptFileProcessor;

import java.io.File;

public class EncryptCommand implements Command {
    private final ObservableEncryptFileProcessor fileProcessor;
    private final File file;

    public EncryptCommand(ObservableEncryptFileProcessor fileProcessor, File file) {
        this.fileProcessor = fileProcessor;
        this.file = file;
    }

    // execute the method top start the encryption process
    @Override
    public void start() {
        fileProcessor.processFile(file);
    }

    @Override
    public FileProcessor getFileProcessor() {
        return fileProcessor;
    }
}
