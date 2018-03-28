package edu.ithaca.group2;

public class veiwAll {
    public void viewAllCards() {
        Workspace theWorkspace = new Workspace();
        System.out.println("Here are your cards:");
        for (int i = 0; i <theWorkspace.cardCount ; i++) {
            System.out.println(theWorkspace.cardList.get(i) +" ." + theWorkspace.cardList.get(i));

        }
    }
}
