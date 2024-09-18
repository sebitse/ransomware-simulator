package com.simulator;

import java.io.File;
import java.util.Scanner;

/**
 * The {@code UserInputHandler} class handles user inputs
 * <p>
 * It encapsulates all input handling logic to interact with the user and retrieve necessary data.
 */
public class UserInputHandler {

    /**
     * A {@code Scanner} object used to read user input.
     */
    private final Scanner scanner;

    /**
     * Constructs a new {@code UserInputHandler} with an initialized {@code Scanner}.
     */
    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user to select an operation (encryption or decryption) and returns the selected option.
     *
     * @return An integer representing the user's choice: 1 for encryption, 2 for decryption.
     */
    public int selectOperation() {
        System.out.println("Select an operation: 1. Encrypt Files  2. Decrypt Files");
        return scanner.nextInt();
    }

    /**
     * Prompts the user to select an encryption algorithm and returns the selected algorithm.
     *
     * @return A string representing the selected encryption algorithm ("AES" or "RSA").
     */
    public String selectAlgorithm() {
        // Consume the newline character left-over from previous input
        scanner.nextLine();
        System.out.println("Select an encryption algorithm (AES or RSA):");
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter the file path of the file they wish to process and returns it as a {@code File} object.
     * Currently, a sample file path is hardcoded for demonstration purposes.
     *
     * @return A {@code File} object representing the selected file path.
     */
    public File selectFile() {
        /*
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        */
        String filePath = "data/sample";  // Hardcoded for demo purposes, change to user input if needed
        return new File(filePath);
    }

    /**
     * Asks the user if they would like to continue performing operations after completing the current one.
     * 'y' -> yes
     * 'n' -> no
     *
     * @return {@code true} if the user wants to perform another operation, {@code false} otherwise.
     */
    public boolean askToContinue() {
        System.out.println("Would you like to perform another operation? (y/n)");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y");
    }
}
