package com.group33.graphics;

import java.util.ArrayList;
import java.util.List;

public class Observables implements Subject {
    private boolean currentState = true;

    private List<Observer> observerList = new ArrayList<>();

    public boolean getCurrentState() {
        return currentState;
    }

    public void setCurrentState(boolean currentState) {

        this.currentState = currentState;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observerList){
            o.update(o);
        }
    }
}
