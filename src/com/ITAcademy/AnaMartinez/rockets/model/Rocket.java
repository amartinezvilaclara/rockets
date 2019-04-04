package com.ITAcademy.AnaMartinez.rockets.model;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class Rocket {

    private String id;
    private int propellersNumber;
    private Propeller[] propellers;

    public Rocket(String id, int propellersNumber) {
        checkValidId(id);
        checkValidPropellerNumber(propellersNumber);
        this.id = id;
        this.propellersNumber = propellersNumber;
        this.propellers = new Propeller[propellersNumber];
        for(int i = 0; i< propellersNumber; i++){
            propellers[i]= new Propeller(0);
        }
    }

    public Rocket(String id, int propellersNumber, int... propellersMaxPower) throws InvalidParameterException {
        checkValidId(id);
        checkValidPropellerNumber(propellersNumber);
        checkEnoughPropellersMaxValues(propellersNumber, propellersMaxPower);
        this.id = id;
        this.propellersNumber = propellersNumber;
        this.propellers = new Propeller[propellersNumber];
        for(int i = 0; i< propellersMaxPower.length; i++){
            propellers[i]= new Propeller(propellersMaxPower[i]);
        }
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
        int[] propellersMaxPower = new int[propellersNumber];
        for(int i = 0; i< propellersNumber; i ++){
            propellersMaxPower[i]= propellers[i].getMaxPower();
        }
        return propellersMaxPower;
    }

    public Propeller[] getPropellers(){
        return  propellers;
    }

    private void checkValidId(String id) throws InvalidParameterException {
        if((id.length() < 8)|| (id.length() > 8)){
            throw new InvalidParameterException("the id length is incorrect. Must be 8 characters");
        }
    }

    private void checkEnoughPropellersMaxValues(int propellersNumber, int[] propellersMaxPower) {
        if (propellersMaxPower.length != propellersNumber) {
            throw new InvalidParameterException("Not all propellers have a maximum power assigned");
        }
    }

    private void checkValidPropellerNumber(int num) {
        if(num <= 0){
            throw  new InvalidParameterException("Incorrect propeller number; the rocket must have at least 1");
        }
    }

    public void accelerate() {
        for (int i = 0; i <propellersNumber; i++) {
            propellers[i].accelerate();
        }
    }

    public void deccelerate() {
        for (int i = 0; i <propellersNumber; i++) {
            propellers[i].deccelarate();
        }
    }

    public int getSpeed() {
        int speed =0;
        for (int i = 0; i <propellersNumber; i++) {
            speed += propellers[i].getActualPower();
        }
        return speed;
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "\n\tcode = '" + id + '\'' +
                ", \n\tactual speed = " + getSpeed() +
                ", \n\tpropellersNumber = " + propellersNumber +
                ", \n\tpropellers = " + Arrays.toString(propellers) +
                "\n}";
    }
}
