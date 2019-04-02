package com.ITAcademy.AnaMartinez.rockets.tests.model;

import com.ITAcademy.AnaMartinez.rockets.model.Rocket;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class RocketTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void ARocketHasACodeAndANumberOfPropellers(){
        Rocket rocket = new Rocket("12345678",3);
        assertNotNull(rocket.getId());
        assertNotNull(rocket.getPropellersNumber());
    }

    @Test
    public void TheRocketIdIs8CharsLong(){
        Rocket rocket = new Rocket("12345678",3);
        assertEquals(8, rocket.getId().length());
    }

    @Test (expected = InvalidParameterException.class)
    public  void TryingToSetAnIdShorterThan8CharsThrowsAnException(){
        Rocket rocket = new Rocket("12345678",3);
        rocket.setId("1234567");
    }

    @Test (expected = InvalidParameterException.class)
    public  void TryingToSetAnIdLongerThan8CharsThrowsAnException(){
        Rocket rocket = new Rocket("12345678",3);
        rocket.setId("123456789");
    }

    @Test
    public void ICanSetAValidId(){
        Rocket rocket = new Rocket("12345678",3);
        rocket.setId("abcdefgh");
        assertEquals("abcdefgh",rocket.getId());
    }

    @Test
    public void ThePropellersHaveAMaxPowerValueEach(){
        Rocket rocket = new Rocket("12345678",3);
        assertNotNull(rocket.getPropellersMaxPower());
    }

    @Test
    public void EachPropellerMustHaveAnAssignedMaxPower(){
        Rocket rocket = new Rocket("12345678",3, 10, 20, 30);
        int[] propellersMaxPower = rocket.getPropellersMaxPower();
        assertEquals(10, propellersMaxPower[0]);
        assertEquals(20, propellersMaxPower[1]);
        assertEquals(30, propellersMaxPower[2]);
    }

    @Test (expected = InvalidParameterException.class)
    public  void PassingNotEnoughNumbersToAssignTheMaxPowerToThePropellersThrowsAnException(){
        Rocket rocket = new Rocket("12345678",3, 10, 20);
    }

    @Test (expected = InvalidParameterException.class)
    public  void PassingTooManyNumbersToAssignTheMaxPowerToThePropellersThrowsAnException(){
        Rocket rocket = new Rocket("12345678",3, 10, 20,30,40);
    }

    @Test (expected = InvalidParameterException.class)
    public void ARocketMustHaveAtLeastOnePropellerOrExceptionIsThrown(){
        Rocket rocket = new Rocket("12345678",0);
    }

    @Test (expected = InvalidParameterException.class)
    public void ANegativeValueAsMaximumPropellerValueThrowsAnException(){
        Rocket rocket = new Rocket("12345678",3, 10, 20, -1);
    }
}