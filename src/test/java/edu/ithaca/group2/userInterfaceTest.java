package edu.ithaca.group2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class userInterfaceTest {

    @Test
    void OptionsTest(){
        int userInput = 1;
        userInterface test = new userInterface();
        assertEquals(0,test.Options(userInput), "this should pass");
    }

    @Test
    void OutOfRangeTest(){
        int userInput = 24;
        userInterface test = new userInterface();
        assertEquals(-1,test.Options(userInput), "this should pass");
    }
}