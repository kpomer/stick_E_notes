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

        if ( priority<0){//priority>cardList.size() ||
            return -1;
        }
        else{
            this.cardList.add(priority, toAdd);
            this.cardCount++;
            return 0;
        }
    }
    public void veiwAllcards(){
        System.out.println("Here are your cards");

        for (int i = 0; i <cardCount; i++) {
            System.out.println(cardList.get(i).getPriority());
            System.out.println(cardList.get(i).getTitle());
            System.out.println(cardList.get(i).getDeadline());
            System.out.println(cardList.get(i).getDescription());





        }
    }
}
