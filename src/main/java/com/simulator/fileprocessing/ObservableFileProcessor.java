package com.simulator.fileprocessing;

import com.simulator.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableFileProcessor extends FileProcessor {
    // I want to implement Observer Design Pattern here
    private final List<Observer> observers = new ArrayList<>();

    // add observers
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Delete the observer from the List
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all the observers
    protected void notify(String message) {
        for (Observer observer : this.observers) {
            observer.update(message);
        }
    }
}
