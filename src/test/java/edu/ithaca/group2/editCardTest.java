package edu.ithaca.group2;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class editCardTest {

    @Test
    void changeFields(){
        //Change the fields of a card that has already been created
        Workspace testWorkspace = new Workspace();
        Card testCard = new Card("title", 0, "description", "deadline");

        assertEquals(0, testWorkspace.addCard(testCard));
        assertEquals("title", testWorkspace.getCard(0).getTitle());
        assertEquals(0, testWorkspace.getCard(0).getPriority());
        assertEquals("description", testWorkspace.getCard(0).getDescription());
        assertEquals("deadline", testWorkspace.getCard(0).getDeadline());

        Card testCard2 = new Card("title2", 0, "description2", "deadline2");
        testWorkspace.addCard(testCard2);
        //added testCard2 to 0 priority
        //SHOULD move testCard to 1 priority
        assertEquals("testCard", testWorkspace.getCard(1).getTitle());

        testWorkspace.getCard(1).changePriority(0);
        testWorkspace.getCard(0).changeTitle("newTitle");
        testWorkspace.getCard(0).changeDescription("newDescription");
        testWorkspace.getCard(0).changeDeadline("newDeadline");

        assertEquals("newTitle", testWorkspace.getCard(0).getTitle());
        assertEquals(0, testWorkspace.getCard(0).getPriority());
        assertEquals("newDescription", testWorkspace.getCard(0).getDescription());
        assertEquals("newDeadline", testWorkspace.getCard(0).getDeadline());

    }

}
