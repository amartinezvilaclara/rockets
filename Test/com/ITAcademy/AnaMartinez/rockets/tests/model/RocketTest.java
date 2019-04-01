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
}