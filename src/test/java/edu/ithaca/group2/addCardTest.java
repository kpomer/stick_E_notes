package edu.ithaca.group2;

public class addCardTest {
    //Cards contain the fields String title, String description, and int priority (which decides the order of the list)

    Card testCard1 = new Card("testCard1Title", "testCard1Description", 1);
    Card testCard2 = new Card("testCard2Title", "testCard1Description", 2);
    Card testCard3 = new Card("testCard3Title", "testCard3Description", 2);
    //Order should be [testCard1Title, testCard3Title, testCard2Title]

    //test that the card fields are entered correctly, and that priority order is correct
    assertEquals("testCard1Title", testCard1.getTitle());
    assertEquals("testCard1Description", testCard1.getDescription());
    assertEquals(1, testCard1.getPriority());

    assertEquals("testCard2Title", testCard2.getTitle());
    assertEquals("testCard2Description", testCard2.getDescription());
    assertEquals(3, testCard2.getPriority());

    assertEquals("testCard3Title", testCard3.getTitle());
    assertEquals("testCard3Description", testCard3.getDescription());
    assertEquals(2, testCard3.getPriority());

    //If there are n cards within the workspace, and a priority of <1 or >(n+1) is entered when creating a new card, print error message
    assertEquals("Sorry, priority number out of bounds.  Try again", Card testCard4 = new Card("testCard4Title", "testCard4Description", 5));
    assertEquals("Sorry, priority number out of bounds.  Try again", Card testCard5 = new Card("testCard5Title", "testCard5Description", 0));
    assertEquals("Sorry, priority number out of bounds.  Try again", Card testCard6 = new Card("testCard6Title", "testCard6Description", -1));

    //If empty list is entered for String title, print error message (description can be empty)
    assertEquals("Sorry, title cannot be empty.  Try again", Card testCard7 = new Card("", "testCard7Description", 1));

    Card testCard8 = new Card("testCard8Title", "", 1);
    assertEquals("", testCard8.getDescription());

}
