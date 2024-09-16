package com.simulator.fileprocessing;

import com.simulator.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableFileProcessor extends FileProcessor {
    // I want to implement Observer Design Pattern here
    private final List<Observer> observers = new ArrayList<>();
}
