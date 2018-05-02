package edu.ithaca.group2;
import java.sql.SQLOutput;
import java.util.*;

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
    public int dateDifference(Date inlist, Date tocompare) {
        long diff =inlist.getTime()-tocompare.getTime();
        diff=(diff / (1000 * 60 * 60 * 24));
        int daystill = (int) diff;
        //System.out.println(daystill);
        return daystill;

    }
    public boolean dateCompare(Date inlist, Date tocompare) {
        if (inlist.after(tocompare)) {
            //System.out.println("Date1 is after Date2");
            return true;
        } else if (inlist.before(tocompare)) {
            //System.out.println("Date1 is before Date2");
            return false;
        } else if (inlist.equals(tocompare)) {
            //System.out.println("Date1 is equal to Date2");
            return true;
        }
        return false;
    }

    public String dateNotifiation(int tilldate, Date datein ) {
        String titles="";
        for (int i = 0; i <cardCount ; i++) {
            Date current =cardList.get(i).getDeadline();
            if(dateCompare(current,datein)==true) {
                if(dateDifference(current,datein)<=tilldate) {
                    titles +=cardList.get(i).getTitle()+" ";

                }

            }

        }
        if(titles==""){
            return"No Cards are upcoming";
        }else{
            System.out.println(titles);
            return "Your "+ titles+ "cards are upcoming";
        }

    }

    public ArrayList<Card> getCardList(){
        return cardList;
    }

    public void setCardList(ArrayList<Card> cardList){
        this.cardList = cardList;
    }
    //Test to see if an entered date is the same as proposed date
    // Test to see that


}
