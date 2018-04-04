package edu.ithaca.group2;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class veiwAllTest {

    @Test
    void testEmptyString(){
        Workspace testWorkspace = new Workspace();

        assertEquals("", testWorkspace.viewAllCards());
    }

    @Test
    void testOneCard(){
        Workspace testWorkspace = new Workspace();
        Card testCard = new Card("title", 0, "description", "Deadline");
        testWorkspace.addCard(testCard);

        assertEquals(testWorkspace.getCard(0).getTitle(), testWorkspace.viewAllCards());
    }

    @Test
    void testMultipleCards(){
        Workspace testWorkspace = new Workspace();
        Card testCard = new Card("title", 0, "description", "Deadline");
        Card testCard2 = new Card("title2", 1, "description2", "Deadline2");
        testWorkspace.addCard(testCard);
        testWorkspace.addCard(testCard2);

        assertEquals(testWorkspace.getCard(0).getTitle(), testWorkspace.viewAllCards());
    }



}