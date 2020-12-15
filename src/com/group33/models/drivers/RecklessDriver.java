package com.group33.models.drivers;

import com.group33.config.Configuration;

public class RecklessDriver implements IDriver {

    private final double RISKFACTOR = Configuration.getRecklessDriverFactor();

    public double getRISKFACTOR() {
        return RISKFACTOR;
    }

}
