package com.ITAcademy.AnaMartinez.rockets.model;

import java.security.InvalidParameterException;

public class Rocket {

    private String id;
    private int propellersNumber;

    public Rocket() {
        this.id = "00000000";
        this.propellersNumber= 0;
    }

    public Rocket(String id, int propellersNumber) {
        checkValidId(id);
        this.id = id;
        this.propellersNumber = propellersNumber;
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

    public void setPropellersNumber(int propellersNumber) {
        this.propellersNumber = propellersNumber;
    }

    private void checkValidId(String id) throws InvalidParameterException {
        if((id.length() < 8)|| (id.length() > 8)) throw new InvalidParameterException("the id lenght is incorrect. Must be 8 characters");
    }
}
