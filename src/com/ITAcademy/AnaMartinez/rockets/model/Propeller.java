package com.ITAcademy.AnaMartinez.rockets.model;

import java.security.InvalidParameterException;

public class Propeller {

    int maxPower;

    public Propeller(int maxPower) throws InvalidParameterException {
        checkValidMaxPower(maxPower);
        this.maxPower = maxPower;
    }

    public int getMaxPower() {
        return maxPower;
    }

    private void checkValidMaxPower(int maxPower) throws InvalidParameterException {
        if(maxPower<0) throw new InvalidParameterException("The propellers max value cannot be a negative number");
    }
}
