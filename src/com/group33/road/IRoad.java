package com.group33.road;

import com.group33.vehicle.Vehicle;

import static com.group33.road.RoadDirection.*;

public interface IRoad {

    void reset();
    void addCar(Vehicle v);
    void moveCars();
}
