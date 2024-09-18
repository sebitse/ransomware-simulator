package com.simulator;


import java.io.File;


public class RansomwareSimulatorApp {

    private final UserInputHandler userInputHandler;
    private final DirectoryProcessor directoryProcessor;

    public RansomwareSimulatorApp() {
        this.userInputHandler = new UserInputHandler();
        this.directoryProcessor = new DirectoryProcessor();
    }

    // Main loop for running the app
    public void run() {
        System.out.println("Ransomware Simulator - Educational Purposes Only");

        boolean running = true;
        while (running) {
            int operation = userInputHandler.selectOperation();
            String algorithm = userInputHandler.selectAlgorithm();
            File directory = userInputHandler.selectFile();

            try {
                if (directory.isDirectory()) {
                    // Delegate directory processing to DirectoryProcessor
                    directoryProcessor.processDirectory(directory, operation, algorithm);
                } else {
                    // Delegate single file processing to DirectoryProcessor
                    directoryProcessor.processSingleFile(directory, operation, algorithm);
                }
            } catch (Exception e) {
                System.err.println("Error during encryption/decryption: " + e.getMessage());
            }

            // Ask the user if they want to continue or exit
            running = userInputHandler.askToContinue();
        }

        System.out.println("Exiting the Ransomware Simulator. Goodbye!");
    }
}
