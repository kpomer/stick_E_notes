package edu.ithaca.group2;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Calendar;
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


    public String viewAllCards() {
        String allCards = "";
        for (int i = 0; i < this.cardCount; i++) {
            allCards = allCards + cardList.get(i).getPriority()+"\t";
            allCards = allCards + cardList.get(i).getTitle();
            if(i!=cardCount-1){
                allCards=allCards+"\n";
            }
            ///Tell the code to change allCards using a for loop of the titles and maybe the priority numbers
            //Make sure to format this string either so that it works with the test (by changing this string or the expected one in the test


        }
        return allCards;
    }

    public int getCardCount(){
        return this.cardCount;
    }

    public void changePriority(Card cardToMove, int newPriority){
        if (newPriority>(cardCount-1) || newPriority<0) {
            System.out.println("Sorry, priority number out of bounds.  Try again.");
        }
        else{
            if (cardToMove.getPriority()!=newPriority) {
                if (newPriority<cardToMove.getPriority()) {
                    for (int p = (newPriority + 1); p < cardCount; p++) {
                        this.getCard(p).setPriority(p);
                    }
                }
                else if (newPriority>cardToMove.getPriority()){
                    for (int p = (cardToMove.getPriority()+1); p <=newPriority; p++) {
                        this.getCard(p).setPriority(p-1);
                    }
                }
                cardList.set(newPriority, cardToMove);
            }
        }
    }
    //Test to see if an entered date is the same as proposed date
    // Test to see that


}
