package edu.ithaca.group2;

import static org.junit.jupiter.api.Assertions.*;


public class addCardTest {
    //Cards contain the fields String title, String description, and int priority (which decides the order of the list)

    Workspace testWorkspace = new Workspace();

    @org.junit.jupiter.api.Test
    public void addNewCardTests() {

        Card testCard1 = new Card("testCard1Title", 0, "testCard1Description", "1/1/2020");
        Card testCard2 = new Card("testCard2Title", 1);
        Card testCard3 = new Card("testCard3Title", 1, "testCard3Description", "1/1/2020");

        //test that the card fields are entered correctly, and that priority order is correct
        testWorkspace.addCard(testCard1);
        testWorkspace.addCard(testCard2);
        testWorkspace.addCard(testCard3);
        //Order should be [testCard1Title, testCard3Title, testCard2Title]

        assertEquals("testCard1Title", testWorkspace.getCard(0).getTitle());
        assertEquals("testCard1Description", testWorkspace.getCard(0).getDescription());
        assertEquals(0, testWorkspace.getCard(0).getPriority());
        assertEquals("1/1/2020", testWorkspace.getCard(0).getDeadline());

        assertEquals("testCard3Title", testWorkspace.getCard(1).getTitle());
        assertEquals("testCard3Description", testWorkspace.getCard(1).getDescription());
        assertEquals(1, testWorkspace.getCard(1).getPriority());
        assertEquals("1/1/2020", testWorkspace.getCard(1).getDeadline());

        assertEquals("testCard2Title", testWorkspace.getCard(2).getTitle());
        assertEquals("", testWorkspace.getCard(2).getDescription());
        assertEquals(2, testWorkspace.getCard(2).getPriority());
        assertEquals("", testWorkspace.getCard(2).getDeadline());

        //If there are n cards within the workspace, and a priority of <0 or >(n+1) is entered when creating a new card, print error message
        Card testCard4 = new Card("testCard4Title",5, "testCard4Description", "1/1/2020");
        Card testCard5 = new Card("testCard5Title", -1, "testCard5Description",  "1/1/2020");
        assertEquals(-1, testWorkspace.addCard(testCard4));
        assertEquals(-1, testWorkspace.addCard(testCard5));

        //If empty list is entered for String title, return -1, otherwise return 0
        Card testCard8 = new Card("", 1, "", "1/1/2020");
        Card testCard9 = new Card("testCard9", 1, "", "1/1/2020");
        assertEquals(-1, testWorkspace.addCard(testCard8));
        assertEquals(0, testWorkspace.addCard(testCard9));

    }

}
