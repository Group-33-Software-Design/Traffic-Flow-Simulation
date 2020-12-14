package com.group33.config;

import com.group33.config.Observer;

public interface Subject {

        public void registerObserver(Observer o);
        public void unregisterObserver(Observer o);
        public void notifyObservers();

}
