package edu.ithaca.group2;
import java.util.ArrayList;

public class Workspace {

    ArrayList<Card> cardList;
    int cardCount;

    public void Workspace(){
        cardList = new ArrayList<Card>();
        cardCount = 0;
    }

    public int addCard(Card toAdd){
        int priority = toAdd.getPriority();

        if (priority>cardCount || priority<0){
            System.out.println("Sorry, priority number out of bounds.  Try again.");
            return -1;
        }
        else if (toAdd.getTitle() == ""){
            System.out.println("Sorry, card must have a title.  Try again.");
            return -1;
        }

        else{
            cardList.add(priority, toAdd);
            this.cardCount++;
            return 0;
        }
    }

    public Card getCard(int priority){
        return cardList.get(priority);
    }

}
