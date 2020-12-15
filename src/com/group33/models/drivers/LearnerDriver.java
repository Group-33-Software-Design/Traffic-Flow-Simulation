package com.group33.models.drivers;

import com.group33.config.Configuration;

public class LearnerDriver implements IDriver {

    private final double RISKFACTOR = Configuration.getLearnerDriverFactor();

    public double getRISKFACTOR() {
        return RISKFACTOR;
    }
}
