package edu.ithaca.group2;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Workspace {

    ArrayList<Card> cardList;
    int cardCount;

    public Workspace(){
        cardList = new ArrayList<Card>();
        cardCount = 0;
    }

    public Workspace(ArrayList<Card> cardList, int cardCount){
        this.cardList = cardList;
        this.cardCount = cardCount;
    }

    /**
     * Takes in a Card which should be added to the workspace
     * checks the priority to know where to add it
     * makes sure priority is valid and fits in the workspace
     * It moves the other cards priorities around to place it correctly
     * @param toAdd card
     * @return int (-1 if card cannot be added, 0 otherwise)
     */
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
            //Change priority of cards following new card
            for (int p = priority; p<cardCount; p++)
            {
                cardList.get(p).setPriority(p+1);
            }
            cardList.add(priority, toAdd);
            cardCount++;
            return 0;
        }
    }

    /**
     * Takes in a Card which should be removed from the workspace
     * checks the priority to know where it will be deleted
     * It moves the other cards priorities around to avoid having an empty space
     * @param cardToDelete Card
     */
    public void deleteCard(Card cardToDelete){
        int priorityToDelete = cardToDelete.getPriority();
        for (int i=priorityToDelete; i<(cardCount-1); i++)
        {
            cardList.set(i, cardList.get(i+1));
            this.getCard(i).setPriority(i);
        }
        this.getCard(cardCount-1).setPriority(cardCount-2);
        cardCount--;
    }

    /**
     * Takes in a priority number
     * Checks that there is a card with this priority
     * Returns this card
     * @param priority int
     * @return card at priority
     */
    public Card getCard(int priority) throws IndexOutOfBoundsException{
        if ((0<= priority) && (priority < cardCount))
        return cardList.get(priority);
        else
        {
            throw new IndexOutOfBoundsException("Priority number " + priority + " is out of bounds");
        }
    }

    /**
     * Takes in a String of card title
     * Checks that there is a card with this title
     * Returns this card
     * @param title String
     * @return card with that title
     */
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


    /**
     * Iterates through all cards in workspce
     * Returns priority number and card title
     * @return String of cards and priorities
     */
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

    /**
     * Takes in a Card to change priority and int of newPriority
     * Changes priority of other cards to allow cardToMove to have its new priority
     * Changes cardToMove to newPriority
     * @param cardToMove card
     * @param newPriority int
     */
    public void changePriority(Card cardToMove, int newPriority){
        if (newPriority>(cardCount-1) || newPriority<0) {
            System.out.println("Sorry, priority number out of bounds.  Try again.");
        }
        else{
            if (cardToMove.getPriority()!=newPriority) {
                if (newPriority<cardToMove.getPriority()) {
                    for (int p = (cardToMove.getPriority()-1); p >= newPriority; p--) {
                        this.getCard(p).setPriority(p+1);
                        cardList.set(p+1, cardList.get(p));
                    }
                    cardList.set(newPriority, cardToMove);
                    cardToMove.setPriority(newPriority);
                }
                else if (newPriority>cardToMove.getPriority()){
                    for (int p = (cardToMove.getPriority()); p <newPriority; p++) {
                        this.getCard(p+1).setPriority(p);
                        cardList.set(p, cardList.get(p+1));
                    }
                    cardList.set(newPriority, cardToMove);
                    cardToMove.setPriority(newPriority);
                }
            }
        }
    }

    public ArrayList<Card> getCardList(){
        return cardList;
    }

    public void setCardList(ArrayList<Card> cardList){
        this.cardList = cardList;
    }


}
