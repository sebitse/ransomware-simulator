package com.simulator.command;

import com.simulator.fileprocessing.FileProcessor;

public interface Command {
    // start the magic here
    void start();

    // New method to return the FileProcessor
    FileProcessor getFileProcessor();
}
