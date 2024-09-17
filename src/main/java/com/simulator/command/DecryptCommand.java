package com.simulator.command;

import com.simulator.fileprocessing.FileProcessor;
import com.simulator.fileprocessing.ObservableDecryptFileProcessor;

import java.io.File;

public class DecryptCommand implements Command {
    private final ObservableDecryptFileProcessor fileProcessor;
    private final File file;

    public DecryptCommand(ObservableDecryptFileProcessor fileProcessor, File file) {
        this.fileProcessor = fileProcessor;
        this.file = file;
    }

    // execute the method to start the decryption process
    @Override
    public void start() {
        fileProcessor.processFile(file);
    }

    @Override
    public FileProcessor getFileProcessor() {
        return fileProcessor;
    }


}
