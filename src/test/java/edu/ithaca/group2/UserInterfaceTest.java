package edu.ithaca.group2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {

    /*
    UserInterface
    Options() While loop
    -switch cases call __Interface() for user input info
    -__Interface() calls __Function(--,--...) which DOES something and should be tested
    Returns 0 for no issues, returns -1 if there is an issue (like adding a card at an illegal priority)


    @Test
    void testAddCardFunction(){
        //returns -1 if card can not be added, and 0 if card is added successfully
        UserInterface start = new UserInterface();
        Card testCard0 = new Card("testCard0", 0, "d", "dead", "blue");
        Card testCard1 = new Card("testCard1", 1, "d", "dead", "blue");
        Card testCard2 = new Card("testCard2", 1, "d", "dead", "blue");
        Card testCard3 = new Card("testCard3", 3, "d", "dead", "blue");
        assertEquals(start.addCardFunction(testCard1), -1);
        assertEquals(start.addCardFunction(testCard0), 0);
        assertEquals(start.addCardFunction(testCard2), 0);
        assertEquals(start.addCardFunction(testCard3), 0);

    }

    @Test
    void testViewCardFunction(){
        //returns "NO CARD" if card is not found, and card info otherwise
        UserInterface start = new UserInterface();
        Card testCard0 = new Card("testCard0", 0, "d", "dead", "blue");
        assertEquals(start.viewCardFunction("testCard0"), "NO CARD");
        start.addCardFunction(testCard0);
        assertEquals(start.viewCardFunction("testCard0"), "testCard0\nID: 0\n\td\nDeadline: dead\nCard Color:blue");

    }

    @Test
    void testViewAllCardsFunction(){
        UserInterface start = new UserInterface();
        assertEquals(start.viewAllCardsFunction(), "");
        Card testCard0 = new Card("testCard0", 0, "d", "dead", "blue");
        start.addCardFunction(testCard0);
        assertEquals(start.viewAllCardsFunction(), "0\ttestCard0");
    }

    @Test
    void testEditCardFunction(){
        UserInterface start = new UserInterface();
        Card testCard0 = new Card("testCard0", 0, "d", "dead", "blue");
        assertEquals(testCard0.viewCard(), "testCard0\nID: 0\n\td\nDeadline: dead\nCard Color:blue");
        start.editCardFunction(testCard0, 1, "newDescription");
        assertEquals(testCard0.viewCard(), "testCard0\nID: 0\n\tnewDescription\nDeadline: dead\nCard Color:blue");
        start.editCardFunction(testCard0, 2, "newDeadline");
        assertEquals(testCard0.viewCard(), "testCard0\nID: 0\n\tnewDescription\nDeadline: newDeadline\nCard Color:blue");
        start.editCardFunction(testCard0, 2, "black");
        assertEquals(testCard0.viewCard(), "testCard0\nID: 0\n\tnewDescription\nDeadline: newDeadline\nCard Color:black");

    }
*/
}
