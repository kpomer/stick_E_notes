package edu.ithaca.group2;

import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class editCardTest {

    @Test
    void changeFields(){
        //Change the fields of a card that has already been created
        Workspace testWorkspace = new Workspace();
        Card testCard = new Card("title", 0, "description", "deadline","red");
        Date test =new Date(0,0,0);

        assertEquals(0, testWorkspace.addCard(testCard));
        assertEquals("title", testWorkspace.getCard(0).getTitle());
        assertEquals(0, testWorkspace.getCard(0).getPriority());
        assertEquals("description", testWorkspace.getCard(0).getDescription());
        assertEquals(test, testWorkspace.getCard(0).getDeadline());

        Card testCard2 = new Card("title2", 0, "description2", "deadline2", "blue");
        testWorkspace.addCard(testCard2);
        //added testCard2 to 0 priority
        //SHOULD move testCard to 1 priority
        assertEquals("title", testWorkspace.getCard(1).getTitle());

        //Must call changePriority in Card and Workspace
        testWorkspace.getCard(1).changePriority(0, testWorkspace.getCardCount());
        testWorkspace.changePriority(testWorkspace.getCard(0), 1);
        testWorkspace.getCard(0).changeTitle("newTitle");
        testWorkspace.getCard(0).changeDescription("newDescription");
        testWorkspace.getCard(0).changeDeadline("newDeadline");

        assertEquals("newTitle", testWorkspace.getCard(0).getTitle());
        assertEquals(0, testWorkspace.getCard(0).getPriority());
        assertEquals("newDescription", testWorkspace.getCard(0).getDescription());
        assertEquals(test, testWorkspace.getCard(0).getDeadline());

    }

    @Test
    void editPriority(){
        UserInterface ui = new UserInterface();
        Workspace tws = new Workspace();
        assertEquals("", tws.viewAllCards());

        Card testCard1 = new Card("testCard1", 0, "d", "d","red");
        tws.addCard(testCard1);
        assertEquals("0\ttestCard1", tws.viewAllCards());
        assertEquals(0, tws.getCard("testCard1").getPriority());

        Card testCard2 = new Card("testCard2", 1, "d", "d","red");
        tws.addCard(testCard2);
        assertEquals("0\ttestCard1\n1\ttestCard2", tws.viewAllCards());
        assertEquals(1, tws.getCard("testCard2").getPriority());

        Card testCard3 = new Card("testCard3", 2, "d", "d","blue");
        tws.addCard(testCard3);
        assertEquals("0\ttestCard1\n1\ttestCard2\n2\ttestCard3", tws.viewAllCards());
        assertEquals(2, tws.getCard("testCard3").getPriority());

        Card testCard4 = new Card("testCard4", 1, "d", "d", "green");
        tws.addCard(testCard4);
        assertEquals("0\ttestCard1\n1\ttestCard4\n2\ttestCard2\n3\ttestCard3", tws.viewAllCards());
        assertEquals(0, tws.getCard("testCard1").getPriority());
        assertEquals(1, tws.getCard("testCard4").getPriority());
        assertEquals(2, tws.getCard("testCard2").getPriority());
        assertEquals(3, tws.getCard("testCard3").getPriority());

        Card testCard5 = new Card("testCard5", 0, "d", "d", "green");
        tws.addCard(testCard5);
        assertEquals("0\ttestCard5\n1\ttestCard1\n2\ttestCard4\n3\ttestCard2\n4\ttestCard3", tws.viewAllCards());
        assertEquals(0, tws.getCard("testCard5").getPriority());
        assertEquals(1, tws.getCard("testCard1").getPriority());
        assertEquals(2, tws.getCard("testCard4").getPriority());
        assertEquals(3, tws.getCard("testCard2").getPriority());
        assertEquals(4, tws.getCard("testCard3").getPriority());

        tws.changePriority(tws.getCard("testCard4"), 1);//Change priority in workspace

        assertEquals("0\ttestCard5\n1\ttestCard4\n2\ttestCard1\n3\ttestCard2\n4\ttestCard3", tws.viewAllCards());
        assertEquals(0, tws.getCard("testCard5").getPriority());
        assertEquals(1, tws.getCard("testCard4").getPriority());
        assertEquals(2, tws.getCard("testCard1").getPriority());
        assertEquals(3, tws.getCard("testCard2").getPriority());
        assertEquals(4, tws.getCard("testCard3").getPriority());

        tws.changePriority(tws.getCard("testCard5"), 4);//Change priority in workspace

        assertEquals("0\ttestCard4\n1\ttestCard1\n2\ttestCard2\n3\ttestCard3\n4\ttestCard5", tws.viewAllCards());
        assertEquals(0, tws.getCard("testCard4").getPriority());
        assertEquals(1, tws.getCard("testCard1").getPriority());
        assertEquals(2, tws.getCard("testCard2").getPriority());
        assertEquals(3, tws.getCard("testCard3").getPriority());
        assertEquals(4, tws.getCard("testCard5").getPriority());

        tws.changePriority(tws.getCard("testCard5"), 3);//Change priority in workspace

        assertEquals("0\ttestCard4\n1\ttestCard1\n2\ttestCard2\n3\ttestCard5\n4\ttestCard3", tws.viewAllCards());
        assertEquals(0, tws.getCard("testCard4").getPriority());
        assertEquals(1, tws.getCard("testCard1").getPriority());
        assertEquals(2, tws.getCard("testCard2").getPriority());
        assertEquals(3, tws.getCard("testCard5").getPriority());
        assertEquals(4, tws.getCard("testCard3").getPriority());

    }

}
