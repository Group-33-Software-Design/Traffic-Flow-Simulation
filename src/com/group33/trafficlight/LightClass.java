package com.group33.trafficlight;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class LightClass implements Subject {

    private boolean trafficstate = true;

    private List<Observer> observerList = new ArrayList<>();

    public boolean isTrafficstate() {
        return trafficstate;
    }

    public void setTrafficstate(boolean trafficstate) {

        this.trafficstate = trafficstate;
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
    public void notifyObservers( ) {
        for(Observer o : observerList){
            o.update(o);
        }
    }
}
