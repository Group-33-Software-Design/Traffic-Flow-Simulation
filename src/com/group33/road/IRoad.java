package com.group33.road;

import com.group33.vehicle.Vehicle;

public interface IRoad {

    void reset();
    void addCar(Vehicle v);
    void moveCars();

}
