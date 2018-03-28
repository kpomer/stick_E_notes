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
            return -1;
        }
        else{
            cardList.add(priority, toAdd);
            this.cardCount++;
            return 0;
        }
    }
    public void veiwAllcards(ArrayList<Card> cardList){
        System.out.println("Here are your cards");

        for (int i = 0; i <cardList.size(); i++) {
            System.out.println(cardList.get(i).getPriority());
            System.out.println(cardList.get(i).getTitle());
            System.out.println(cardList.get(i).getDeadline());
            System.out.println(cardList.get(i).getDescription());





        }
    }
}
