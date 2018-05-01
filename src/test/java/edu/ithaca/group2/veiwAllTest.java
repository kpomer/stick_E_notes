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
        Card testCard = new Card("title", 0, "description", "Deadline","Blue");
        testWorkspace.addCard(testCard);

        String titleList= testWorkspace.getCard(0).getPriority()+"\t"+testWorkspace.getCard(0).getTitle();


        assertEquals(titleList, testWorkspace.viewAllCards());
        System.out.println(testWorkspace.viewAllCards());
    }

    @Test
    void testMultipleCards(){
        Workspace testWorkspace = new Workspace();
        Card testCard = new Card("title", 0, "description", "Deadline","white");
        Card testCard2 = new Card("title2", 1, "description2", "Deadline2","Green");
        testWorkspace.addCard(testCard);
        testWorkspace.addCard(testCard2);

        String titleList = testWorkspace.getCard(0).getPriority()+"\t"+testWorkspace.getCard(0).getTitle()+"\n";
        String titleList2 = testWorkspace.getCard(1).getPriority()+"\t"+testWorkspace.getCard(1).getTitle();

        assertEquals(titleList+titleList2, testWorkspace.viewAllCards());
        System.out.println(testWorkspace.viewAllCards());
    }
    @Test
    void testMutipleCardsandPriorityChange(){
        Workspace tmc =new Workspace();
        Card testCard = new Card("title",0,"description","deadline","Pink");
        tmc.addCard(testCard);
        for (int i = 0; i <4 ; i++) {
            Card testcard2= new Card("title"+i,0);
            tmc.addCard(testcard2);
        }
        String titleList = tmc.getCard("title3").getPriority()+"\t"+tmc.getCard("title3").getTitle()+"\n";
        String titleList2 = tmc.getCard("title2").getPriority()+"\t"+tmc.getCard("title2").getTitle()+"\n";
        String titleList3 = tmc.getCard("title1").getPriority()+"\t"+tmc.getCard("title1").getTitle()+"\n";
        String titleList4 = tmc.getCard("title0").getPriority()+"\t"+tmc.getCard("title0").getTitle()+"\n";
        String titleList5 = tmc.getCard("title").getPriority()+"\t"+tmc.getCard("title").getTitle();
        assertEquals(titleList+titleList2+titleList3+titleList4+titleList5,tmc.viewAllCards());
        System.out.println(tmc.viewAllCards());

    }



}