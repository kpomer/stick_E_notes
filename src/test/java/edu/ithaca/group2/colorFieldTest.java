package edu.ithaca.group2;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class colorFieldTest {

    @Test
    void printsCFTest(){

        Workspace testWorkspace = new Workspace();
        Card testCard = new Card("title", 0, "description", "deadline", "red");
        assertEquals(0, testWorkspace.addCard(testCard));
        assertEquals("title", testWorkspace.getCard(0).getTitle());
        assertEquals(0, testWorkspace.getCard(0).getPriority());
        assertEquals("description", testWorkspace.getCard(0).getDescription());
        assertEquals("deadline", testWorkspace.getCard(0).getDeadline());
        assertEquals("red",testWorkspace.getCard(0).getColor());
    }
    @Test
    void capitalizationCatch(){
        Workspace testWorkspace = new Workspace();
        Card testCard = new Card("title", 0, "description", "deadline", "RED");
        assertEquals(0, testWorkspace.addCard(testCard));
        assertEquals("title", testWorkspace.getCard(0).getTitle());
        assertEquals(0, testWorkspace.getCard(0).getPriority());
        assertEquals("description", testWorkspace.getCard(0).getDescription());
        assertEquals("deadline", testWorkspace.getCard(0).getDeadline());
        assertEquals("red",testWorkspace.getCard(0).getColor());

    }


}