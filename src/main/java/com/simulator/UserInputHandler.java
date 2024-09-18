package com.simulator;

import java.io.File;
import java.util.Scanner;

public class UserInputHandler {
    private final Scanner scanner;

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int selectOperation() {
        System.out.println("Select an operation: 1. Encrypt Files  2. Decrypt Files");
        return scanner.nextInt();
    }

    public String selectAlgorithm() {
        scanner.nextLine();  // Consume newline left-over
        System.out.println("Select an encryption algorithm (AES or RSA):");
        return scanner.nextLine();
    }

    public File selectFile() {
        /*
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
         */
        String filePath = "data/sample/sample1.txt";
        return new File(filePath);
    }

    public boolean askToContinue() {
        System.out.println("Would you like to perform another operation? (y/n)");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y");
    }
}
