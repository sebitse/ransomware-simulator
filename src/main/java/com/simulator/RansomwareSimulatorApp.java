package com.simulator;

import com.simulator.keymanagement.KeyManager;

import java.util.Scanner;

public class RansomwareSimulatorApp {
    private final Scanner scanner;
    private final KeyManager keyManager;

    public RansomwareSimulatorApp() {
        this.scanner = new Scanner(System.in);
        this.keyManager = KeyManager.getInstance();
    }

    public void run() {
        System.out.println("Ransomware Simulator - Educational Purposes Only");
    }
}
