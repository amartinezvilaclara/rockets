package com.ITAcademy.AnaMartinez.rockets.view;

import com.ITAcademy.AnaMartinez.rockets.model.Rocket;

public class Main {

    public static void main(String args[]){
        Rocket[] rockets = new Rocket[2];
        rockets[0] = new Rocket("32WESSDS",3, 10, 30, 80);
        rockets[1] = new Rocket("LDSFJA32",6,30,40,50,50,30,10);
        int[] propellersMaxPower;

        System.out.println("The number of rockets created is: "+ rockets.length);
        System.out.println("--------------------------------------");
        for (int i = 0; i <rockets.length; i++) {
            /*System.out.println("The rocket " + i + ":");
            System.out.println("\t code: " + rockets[i].getId());
            System.out.print("\t propellers: " + rockets[i].getPropellersNumber()
                    + " = [");
            propellersMaxPower= rockets[i].getPropellersMaxPower();
            for(int j = 0; j<(propellersMaxPower.length-1); j++){
                System.out.print(propellersMaxPower[j] + ", ");
            }
            System.out.println(propellersMaxPower[propellersMaxPower.length-1] +"]");*/
            System.out.println(rockets[i].toString());
        }
    }



}
