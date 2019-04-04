package com.ITAcademy.AnaMartinez.rockets.model;

import java.security.InvalidParameterException;

public class Propeller {

    int maxPower;
    int actualPower;

    public Propeller(int maxPower) throws InvalidParameterException {
        checkValidMaxPower(maxPower);
        this.maxPower = maxPower;
        this.actualPower= 0;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public int getActualPower() {
        return actualPower;
    }

    private void checkValidMaxPower(int maxPower) throws InvalidParameterException {
        if(maxPower<0) throw new InvalidParameterException("The propellers max value cannot be a negative number");
    }

    public void accelerate(){
        actualPower+=10;
        if(actualPower > maxPower){
            actualPower = maxPower;
        }
    }

    public void deccelarate(){
        actualPower-=10;
        if(actualPower < 0){
            actualPower = 0;
        }
    }

    @Override
    public String toString() {
        return "\n\t\t{" +
                "Power = " + actualPower + "," +
                "maxPower = " + maxPower +
                "}";
    }
}
