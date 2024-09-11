package com.simulator.fileprocessing;

import java.io.File;

public abstract class FileProcessor {
    // The template method that defines the steps for processing a file
    public final void processFile(File file) {
        loadFile(file);          // Step 1: Load the file (standard)
        transformFile(file);     // Step 2: Transform the file (specific to subclasses)
        saveFile(file);          // Step 3: Save the file (standard)
    }

    // Step 1: Load the file (common for all file operations)
    private void loadFile(File file) {
        System.out.println("Loading file: " + file.getName());
    }

    // Step 3: Save the file (common for all file operations)
    private void saveFile(File file) {
        System.out.println("Saving file: " + file.getName());
    }

    // Step 2: Transform the file (can be different)
    protected abstract void transformFile(File file);
}
