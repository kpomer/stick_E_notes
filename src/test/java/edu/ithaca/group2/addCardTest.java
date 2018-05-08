package edu.ithaca.group2;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class addCardTest {
    //Cards contain the fields String title, String description, and int priority (which decides the order of the list), String deadline

    @Test
    void titleCorrect() {
        //Test that title shows up correctly, and that card is NOT added when title = ""
        Workspace testWorkspace = new Workspace();

        Card testCardA = new Card("testCardATitle", 0, "", "","");
        Card testCardB = new Card("", 0, "", "","");

        assertEquals(0, testWorkspace.addCard(testCardA));
        assertEquals("testCardATitle", testWorkspace.getCard(0).getTitle());
        assertEquals(-1, testWorkspace.addCard(testCardB));
        assertEquals("testCardATitle", testWorkspace.getCard(0).getTitle());
    }

    @Test
    void fieldsCorrectTest(){
        Workspace testWorkspace = new Workspace();

        //Test both Card constructors
        Card testCard1 = new Card("testCard1Title", 0, "testCard1Description", "1/1/2020", "red");
        Card testCard2 = new Card("testCard2Title", 1);
        Card testCard3 = new Card("testCard3Title", 1, "testCard3Description", "1/1/2020","blue");

        //test Dates to test against
        //Date test;
        //Date test2;
        //Date test3;
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

        //Test Exception
        boolean thrown = false;

        try {
            testWorkspace.getCard(10);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    void priorityNumberTests() {
        Workspace testWorkspace = new Workspace();

        //If there are n cards within the workspace, and a priority of <0 or >(n+1) is entered when creating a new card, print error message
        Card testCard4 = new Card("testCard4Title", 5, "testCard4Description", "1/1/2020","pink");
        Card testCard5 = new Card("testCard5Title", -1, "testCard5Description", "1/1/2020", "pink");
        Card testCard6 = new Card("testCard6Title", 0, "testCard6Description", "1/1/2020", "pink");
        Card testCard7 = new Card("testCard7Title", 2);

        assertEquals(-1, testWorkspace.addCard(testCard4));
        assertEquals(-1, testWorkspace.addCard(testCard5));
        assertEquals(0, testWorkspace.addCard(testCard6));
        assertEquals(-1, testWorkspace.addCard(testCard7)); //Edge case
    }

    @Test
    void searchByTitle(){
        Workspace testWorkspace = new Workspace();

        Card testCard8 = new Card("testCard8Title", 0, "testCard8Description", "1/1/2020","blue");
        Card testCard9 = new Card("testCard9Title", 1);
        Card testCard10 = new Card("testCard10Title", 1, "testCard10Description", "1/1/2020","purple");
        Card testCard11 = new Card("testCard11Title", 0);

        testWorkspace.addCard(testCard8);
        testWorkspace.addCard(testCard9);
        testWorkspace.addCard(testCard10);
        testWorkspace.addCard(testCard11);
        //Order should be 11, 8, 10, 9

        assertEquals(0, testWorkspace.getCard("testCard11Title").getPriority());
        assertEquals(1, testWorkspace.getCard("testCard8Title").getPriority());
        assertEquals(2, testWorkspace.getCard("testCard10Title").getPriority());
        assertEquals(3, testWorkspace.getCard("testCard9Title").getPriority());

        //Test Exception
        boolean thrown = false;

        try {
            testWorkspace.getCard("fakeCard");
        } catch (NoSuchElementException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }


}
