package edu.ithaca.group2;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class deleteCardTest {
    //Cards contain the fields String title, String description, and int priority (which decides the order of the list), String deadline

    @Test
    void deleteOnlyCard() {
        Workspace testWorkspace = new Workspace();

        Card title1 = new Card("title1", 0, "", "", "");
        testWorkspace.addCard(title1);
        assertEquals("0\ttitle1", testWorkspace.viewAllCards());
        assertEquals(1, testWorkspace.getCardCount());

        testWorkspace.deleteCard(title1);

        assertEquals("", testWorkspace.viewAllCards());
        assertEquals(0, testWorkspace.getCardCount());

    }

    void deleteFirstCard() {
        Workspace testWorkspace = new Workspace();

        Card title1 = new Card("title1", 0, "", "", "");
        Card title2 = new Card("title2", 0, "", "", "");
        Card title3 = new Card("title3", 0, "", "", "");
        Card title4 = new Card("title4", 0, "", "", "");

        testWorkspace.addCard(title1);
        testWorkspace.addCard(title2);
        testWorkspace.addCard(title3);
        testWorkspace.addCard(title4);

        assertEquals("0\ttitle1\n1\ttitle2\n2\ttitle3\n3\ttitle4\n", testWorkspace.viewAllCards());
        assertEquals(4, testWorkspace.getCardCount());

        testWorkspace.deleteCard(title1);

        //Priority numbers should change
        assertEquals("0\ttitle2\n1\ttitle3\n2\ttitle4\n", testWorkspace.viewAllCards());
        assertEquals(3, testWorkspace.getCardCount());

        assertEquals(0, testWorkspace.getCard("title2").getPriority());
        assertEquals(1, testWorkspace.getCard("title3").getPriority());
        assertEquals(2, testWorkspace.getCard("title4").getPriority());

    }

    void deleteLastCard() {
        Workspace testWorkspace = new Workspace();

        Card title1 = new Card("title1", 0, "", "", "");
        Card title2 = new Card("title2", 0, "", "", "");
        Card title3 = new Card("title3", 0, "", "", "");
        Card title4 = new Card("title4", 0, "", "", "");

        testWorkspace.addCard(title1);
        testWorkspace.addCard(title2);
        testWorkspace.addCard(title3);
        testWorkspace.addCard(title4);

        assertEquals("0\ttitle1\n1\ttitle2\n2\ttitle3\n3\ttitle4\n", testWorkspace.viewAllCards());
        assertEquals(4, testWorkspace.getCardCount());

        testWorkspace.deleteCard(title4);

        //Priority numbers NOT should change
        assertEquals("0\ttitle1\n1\ttitle2\n2\ttitle3\n", testWorkspace.viewAllCards());
        assertEquals(3, testWorkspace.getCardCount());

        assertEquals(0, testWorkspace.getCard("title1").getPriority());
        assertEquals(1, testWorkspace.getCard("title2").getPriority());
        assertEquals(2, testWorkspace.getCard("title3").getPriority());

    }

    void deleteMiddleCard() {
        Workspace testWorkspace = new Workspace();

        Card title1 = new Card("title1", 0, "", "", "");
        Card title2 = new Card("title2", 0, "", "", "");
        Card title3 = new Card("title3", 0, "", "", "");
        Card title4 = new Card("title4", 0, "", "", "");

        testWorkspace.addCard(title1);
        testWorkspace.addCard(title2);
        testWorkspace.addCard(title3);
        testWorkspace.addCard(title4);

        assertEquals("0\ttitle1\n1\ttitle2\n2\ttitle3\n3\ttitle4\n", testWorkspace.viewAllCards());
        assertEquals(4, testWorkspace.getCardCount());

        testWorkspace.deleteCard(title2);

        //Some priority numbers should change
        assertEquals("0\ttitle1\n1\ttitle3\n2\ttitle4\n", testWorkspace.viewAllCards());
        assertEquals(3, testWorkspace.getCardCount());

        assertEquals(0, testWorkspace.getCard("title1").getPriority());
        assertEquals(1, testWorkspace.getCard("title3").getPriority());
        assertEquals(2, testWorkspace.getCard("title4").getPriority());

        testWorkspace.deleteCard(title3);

        //Some priority numbers should change
        assertEquals("0\ttitle1\n\t1\ttitle4\n", testWorkspace.viewAllCards());
        assertEquals(2, testWorkspace.getCardCount());

        assertEquals(0, testWorkspace.getCard("title1").getPriority());
        assertEquals(1, testWorkspace.getCard("title4").getPriority());


    }
}