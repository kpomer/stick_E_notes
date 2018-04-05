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

        String titleList= testWorkspace.getCard(0).getPriority()+"\t"+testWorkspace.getCard(0).getTitle();


        assertEquals(titleList, testWorkspace.viewAllCards());
        System.out.println(testWorkspace.viewAllCards());
    }

    @Test
    void testMultipleCards(){
        Workspace testWorkspace = new Workspace();
        Card testCard = new Card("title", 0, "description", "Deadline");
        Card testCard2 = new Card("title2", 1, "description2", "Deadline2");
        testWorkspace.addCard(testCard);
        testWorkspace.addCard(testCard2);

        String titleList = testWorkspace.getCard(0).getPriority()+"\t"+testWorkspace.getCard(0).getTitle()+"\n";
        String titleList2 = testWorkspace.getCard(1).getPriority()+"\t"+testWorkspace.getCard(1).getTitle();

        assertEquals(titleList+titleList2, testWorkspace.viewAllCards());
        System.out.println(testWorkspace.viewAllCards());
    }



}