package com.group33.config;

import com.group33.config.Observer;
import com.group33.config.Subject;

import java.util.ArrayList;
import java.util.List;

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
