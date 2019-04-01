package com.ITAcademy.AnaMartinez.rockets.model;

import java.security.InvalidParameterException;

public class Rocket {

    private String id;
    private int propellersNumber;
    private int[] propellersMaxPower;

    public Rocket(String id, int propellersNumber) {
        checkValidId(id);
        checkValidPropellerNumber(propellersNumber);
        this.id = id;
        this.propellersNumber = propellersNumber;
        this.propellersMaxPower = new int[propellersNumber];
    }


    public Rocket(String id, int propellersNumber, int... propellersMaxPower) {
        checkValidId(id);
        checkValidPropellerNumber(propellersNumber);
        checkValidPropellersMaxValues(propellersNumber, propellersMaxPower);
        this.id = id;
        this.propellersNumber = propellersNumber;
        this.propellersMaxPower = new int[propellersNumber];
        System.arraycopy(propellersMaxPower, 0, this.propellersMaxPower, 0, propellersMaxPower.length);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws InvalidParameterException {
        checkValidId(id);
        this.id = id;
    }

    public int getPropellersNumber() {
        return propellersNumber;
    }

    public int[] getPropellersMaxPower() {
        return propellersMaxPower;
    }

    private void checkValidId(String id) throws InvalidParameterException {
        if((id.length() < 8)|| (id.length() > 8)){
            throw new InvalidParameterException("the id length is incorrect. Must be 8 characters");
        }
    }

    private void checkValidPropellersMaxValues(int propellersNumber, int[] propellersMaxPower) {
        if (propellersMaxPower.length != propellersNumber) {
            throw new InvalidParameterException("Not all propellers have a maximum power assigned");
        }
        for (int i = 0; i < propellersNumber; i++) {
            if (propellersMaxPower[i] < 0) {
                throw new InvalidParameterException("The propellers max value cannot be a negative number");
            }
        }
    }

    private void checkValidPropellerNumber(int num) {
        if(num <= 0){
            throw  new InvalidParameterException("Incorrect propeller number; the rocket must have at least 1");
        }
    }
}
