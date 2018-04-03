package edu.ithaca.group2;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Workspace {

    ArrayList<Card> cardList;
    int cardCount;

    public Workspace(){
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
            //Change priority of cards following new card
            for (int p = (priority+1); p<cardCount; p++)
            {
                this.getCard(p).setPriority(p);
            }
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

    public Card getCard(int priority) throws IndexOutOfBoundsException{
        if ((0<= priority) && (priority < cardCount))
            return cardList.get(priority);
        else
        {
            throw new IndexOutOfBoundsException("Priority number " + priority + " is out of bounds");
        }
    }

    public Card getCard(String title) throws NoSuchElementException{


        for(int p = 0; p<cardCount; p++)
        {

            if (cardList.get(p).getTitle().equals(title))
            {

//                System.out.println(cardList.get(p).getTitle());
//                System.out.println(title);
                return cardList.get(p);
            }
        }
        throw new NoSuchElementException("Could not find Title: " + title);
    }


}
