package com.simulator;

import java.io.File;

/**
 * The {@code RansomwareSimulatorApp} class serves as the main entry point for running the ransomware simulation.
 * <p>
 * It interacts with the user through the {@code UserInputHandler}, and processes files or directories by
 * delegating tasks to the {@code DirectoryProcessor}.
 * <p>
 * The application runs in a loop, allowing users to repeatedly encrypt or decrypt files or directories until
 * they choose to exit.
 */
public class RansomwareSimulatorApp {

    /**
     * Handles user input, such as selecting operations, algorithms, and files.
     */
    private final UserInputHandler userInputHandler;

    /**
     * Handles the processing of directories and files, applying encryption or decryption.
     */
    private final DirectoryProcessor directoryProcessor;

    /**
     * Constructs a new {@code RansomwareSimulatorApp} instance, initializing the {@code UserInputHandler}
     * and {@code DirectoryProcessor}.
     */
    public RansomwareSimulatorApp() {
        this.userInputHandler = new UserInputHandler();
        this.directoryProcessor = new DirectoryProcessor();
    }

    /**
     * Starts the main loop of the application, allowing the user to choose operations, select files or directories,
     * and perform encryption or decryption tasks.
     * <p>
     * The loop continues until the user chooses to exit by indicating they no longer want to perform more operations.
     */
    public void run() {
        System.out.println("Ransomware Simulator - Educational Purposes Only");

        boolean running = true;
        while (running) {
            // Prompt the user for the operation (encrypt or decrypt)
            int operation = userInputHandler.selectOperation();

            // Prompt the user for the encryption algorithm (AES or RSA)
            String algorithm = userInputHandler.selectAlgorithm();

            // Prompt the user for the file or directory to process
            File directory = userInputHandler.selectFile();

            try {
                // If the input is a directory, process the entire directory
                if (directory.isDirectory()) {
                    directoryProcessor.processDirectory(directory, operation, algorithm);
                } else {
                    // Otherwise, process a single file
                    directoryProcessor.processSingleFile(directory, operation, algorithm);
                }
            } catch (Exception e) {
                System.err.println("Error during encryption/decryption: " + e.getMessage());
            }

            // Ask the user if they want to perform another operation or exit
            running = userInputHandler.askToContinue();
        }

        System.out.println("Exiting the Ransomware Simulator. Goodbye!");
    }
}
