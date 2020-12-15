package com.group33.models.drivers;

import com.group33.config.Configuration;

public class ExperiencedDriver implements IDriver {

    private final double RISKFACTOR = Configuration.getExperiencedDriverFactor();

    public double getRISKFACTOR() {
        return RISKFACTOR;
    }
}
