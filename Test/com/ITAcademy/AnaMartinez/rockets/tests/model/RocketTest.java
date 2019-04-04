package com.ITAcademy.AnaMartinez.rockets.tests.model;

import com.ITAcademy.AnaMartinez.rockets.model.Propeller;
import com.ITAcademy.AnaMartinez.rockets.model.Rocket;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class RocketTest {

    @Before
    public void setUp(){
    }

    @Test
    public void ARocketHasACodeAndANumberOfPropellers(){
        Rocket rocket = new Rocket("12345678",3);
        assertNotNull(rocket.getId());
        assertEquals(3, rocket.getPropellersNumber());
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
        new Rocket("12345678",3, 10, 20);
    }

    @Test (expected = InvalidParameterException.class)
    public  void PassingTooManyNumbersToAssignTheMaxPowerToThePropellersThrowsAnException(){
        new Rocket("12345678",3, 10, 20,30,40);
    }

    @Test (expected = InvalidParameterException.class)
    public void ARocketMustHaveAtLeastOnePropellerOrExceptionIsThrown(){
        new Rocket("12345678",0);
    }

    @Test (expected = InvalidParameterException.class)
    public void ANegativeValueAsMaximumPropellerValueThrowsAnException(){
        new Rocket("12345678",3, 10, 20, -1);
    }

    @Test
    public void ThePropellersHaveAnActualPowerInitTo0(){
        Rocket rocket = new Rocket("12345678",3, 10, 20,30);
        assertEquals(0, rocket.getPropellers()[0].getActualPower());
        assertEquals(0, rocket.getPropellers()[1].getActualPower());
        assertEquals(0, rocket.getPropellers()[2].getActualPower());
    }

    @Test
    public void ThePropellersCanBeAcceleratedBy10u(){
        Propeller propeller = new Propeller(20);
        propeller.accelerate();
        assertEquals(10, propeller.getActualPower());
    }

    @Test
    public void ThePropellerCannotAccelerateMoreThanMaxPower(){
        Propeller propeller = new Propeller(20);
        propeller.accelerate();
        propeller.accelerate();
        propeller.accelerate();
        assertEquals(20, propeller.getActualPower());
    }

    @Test
    public void ThePropellerCanDecelerateBy10u(){
        Propeller propeller = new Propeller(20);
        propeller.accelerate();
        propeller.accelerate();
        propeller.deccelarate();
        assertEquals(10, propeller.getActualPower());
    }

    @Test
    public void ThePropellerCannotDecelerateUnder0(){
        Propeller propeller = new Propeller(20);
        propeller.deccelarate();
        assertEquals(0, propeller.getActualPower());
    }

    @Test
    public void theRocketCanAccelerateBy10uByPropeller(){
        Rocket rocket = new Rocket("12345678",3, 10, 20,30);
        rocket.accelerate();
        assertEquals(10, rocket.getPropellers()[0].getActualPower());
        assertEquals(10, rocket.getPropellers()[1].getActualPower());
        assertEquals(10, rocket.getPropellers()[2].getActualPower());
    }

    @Test
    public void theRocketCanBeDeceleratedBy10uByPropeller(){
        Rocket rocket = new Rocket("12345678",3, 10, 20,30);
        rocket.accelerate();
        rocket.accelerate();
        rocket.deccelerate();
        assertEquals(0, rocket.getPropellers()[0].getActualPower());
        assertEquals(10, rocket.getPropellers()[1].getActualPower());
        assertEquals(10, rocket.getPropellers()[2].getActualPower());
    }

    @Test
    public void TheRocketHasATotalPower(){
        Rocket rocket = new Rocket("12345678",3, 10, 20,30);
        rocket.accelerate();
        rocket.accelerate();
        rocket.deccelerate();
        assertEquals(20, rocket.getTotalPower());
    }

    @Test
    public void TheRocketHasANonFrictionCalculatedSpeedInitTo0(){
        Rocket rocket = new Rocket("12345678",3, 10, 20,30);
        assertEquals(0,rocket.getSpeed(), 0.00001);
    }

    @Test
    public void TheRocketHasANonFrictionCalculatedSpeed(){
        Rocket rocket = new Rocket("12345678",3, 10, 20,30);
        rocket.accelerate();
        rocket.accelerate();
        rocket.deccelerate();
        assertEquals(447.2135954999579,rocket.getSpeed(), 0.00001);
    }
}