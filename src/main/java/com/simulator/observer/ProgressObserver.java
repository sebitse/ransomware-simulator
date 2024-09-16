package com.simulator.observer;

public class ProgressObserver implements Observer {
    @Override
    public void update(String message) {
        // print progress messages
        System.out.println(message);
    }
}
