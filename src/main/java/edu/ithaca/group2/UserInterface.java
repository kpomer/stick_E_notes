package edu.ithaca.group2;
import java.sql.SQLOutput;
import java.util.*;

public class UserInterface {

    //TODO: Change this page to the following format

    //While loop of Options
    //Options have switch case which calls __Interface() functions
    //__Interface() functions collect user input
    //__Interface() functions call __Function(params) functions with params from user input

    //TODO: Do we need all of these scanners or can we simply use one
    private Scanner reader2 = new Scanner(System.in);
    private Scanner reader3 = new Scanner(System.in);
    private Scanner title = new Scanner(System.in);
    private Scanner priority = new Scanner(System.in);
    private Scanner description = new Scanner(System.in);
    private Scanner deadline = new Scanner(System.in);
    private Scanner color = new Scanner(System.in);
    private boolean flag = true;

    private Workspace list = new Workspace();


    private void changeFlag() {
        flag = false;
    }
    //user makes selection from the list

    private int Options() {
        //implementing scanner
        Scanner reader1 = new Scanner(System.in);

        System.out.println("\n Hello user,");
        System.out.println("How may I be of assistance to you today?");
        printList();

        //first instance of the CardList


        while (flag) {
            System.out.println("Which task do you want to accomplish?(1-6) \n");

            int choice = reader1.nextInt();


            switch (choice) {

                case 1: //add Card
                    addNewCardSimple();
                    break;
                case 2: //View a Card
                    viewCardInterface();
                    break;

                case 3: //Print all Cards(finish later)
                    System.out.println("Are you sure that you want to VIEW the CARD LIST?(y/n)");
                    String confirmation = reader2.next();
                    if (confirmation.toLowerCase().equals("y")) {
                        System.out.println(list.viewAllCards());
                        break;
                    }
                    break;

                case 4: //Quit
                    System.out.println("Are you sure that you want to QUIT?(y/n)");
                    confirmation = reader2.next();
                    if (confirmation.toLowerCase().equals("y")) {
                        System.out.println("Application shutting down");
                        changeFlag();
                        break;
                    }
                    break;

                case 5: //Print list of options
                    printList();
                    break;

                case 6://Edit card that is already in workspace
                    editCardInterface();
                    break;
                    
                default:
                    System.out.println("The choice selected is invalid. Try again");
                    System.out.println("If you want a list of possible actions, press 5 when prompted");
                    System.out.println("-------------------------------------------------------------");
                    printList();

            }

        }
        System.out.println("Program is terminating");
        System.out.println("-------------------------------------------------------------");

        return 0;
    }

    //case 1
    private void addCardInterface() {
        System.out.println("Are you sure that you want to ADD a card?(y/n)");
        //String confirmation = reader2.next();
        String confirmation = reader2.nextLine();
        if (confirmation.toLowerCase().equals("y")) {

            System.out.println("Enter your Title: \n");
            String CardTitle = title.nextLine();
            System.out.println("--------------------");

            System.out.println("Enter the priority for this card:(0-10)");
            int CardPriority = priority.nextInt();
            System.out.println("----------------------------------------");

            System.out.println("Provide a description for the card(This is optional)");
            String CardDescription = description.nextLine();
            System.out.println("----------------------------------------------------");

            System.out.println("When is your deadline?");
            String CardDeadline = deadline.nextLine();
            System.out.println("----------------------------------------------------");

            System.out.println("Select a color");
            String CardColor = color.nextLine();
            if(CardColor.equals("")) {
                CardColor = "white";
            }
            System.out.println("----------------------------------------------------");


            Card newCard = new Card(CardTitle, CardPriority, CardDescription, CardDeadline,CardColor);
            int isAdded = list.addCard(newCard);

            //newCard.viewCard();

            if (isAdded == 0) {
                System.out.println("You have added a card successfully");
            }
            Options();


        } else {
            Options();
        }

    }

    private void addNewCardSimple(){
        String CardColor = "white"; //default
        String CardDeadline = ""; //Default
        String CardDescription = ""; //Default
        System.out.println("Are you sure that you want to ADD a card?(y/n)");
        //String confirmation = reader2.next();
        String confirmation = reader2.nextLine();
        if (confirmation.toLowerCase().equals("y")) {

            System.out.println("Enter your Title: \n");
            String CardTitle = title.nextLine();
            System.out.println("--------------------");

            System.out.println("Enter the priority for this card:(0-10)");
            int CardPriority = priority.nextInt();
            System.out.println("----------------------------------------");

            boolean changeFields = false;
        System.out.println("Would you like to add more fields? (y/n)");
        String newConfirmation = reader2.nextLine();
        if (newConfirmation.toLowerCase().equals("y")){
            changeFields = true;
            }
        while (changeFields) {

            System.out.println("Select Card Field to Add\nOtherwise select '0'\n");


            System.out.println("-----List of Fields-----");
            System.out.println("-EXIT-(0)");
            System.out.println("-Description-(1)");
            System.out.println("-Deadline-(2)");
            System.out.println("-Card Color-(3)");
            System.out.println("-------------------------\n");

            int field = reader2.nextInt();

            switch(field) {

                case 1:
                    System.out.println("Provide a description for the card:");
                    CardDescription = description.nextLine();
                    System.out.println("----------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Provide a deadline for the card:");
                    CardDeadline = deadline.nextLine();
                    System.out.println("----------------------------------------------------");
                    break;
                case(3):
                    System.out.println("Select a color for your card");
                    CardColor = color.nextLine().toLowerCase();
                    System.out.println("----------------------------------------------------");

                case 0:
                default:
                    changeFields = false;
            }
        }
            Card newCard = new Card(CardTitle, CardPriority, CardDescription, CardDeadline, CardColor);
            int isAdded = list.addCard(newCard);

            //newCard.viewCard();

            if (isAdded == 0) {
                System.out.println("You have added a card successfully");
            }
            Options();


        } else {
            Options();
        }
    }

    //case2
    private void viewCardInterface() {
        System.out.println("Are you sure that you want to VIEW a card?(y/n)");
        String confirmation = reader2.next();
        if (confirmation.toLowerCase().equals("y")) {
            System.out.println("Enter Card Title");
           String CardTitle = title.nextLine();
           boolean inList = false;
           for (int p=0; p<list.getCardCount(); p++) {
               if (list.getCard(p).getTitle().equals(CardTitle)) {
                   inList = true;
               }
           }

           if (inList==true) {
               System.out.println(list.getCard(CardTitle).viewCard());
           }
           else{
                   System.out.println(CardTitle+" is not found in the Workspace\n\n");
           }

            Options();


        } else {
            Options();
        }
    }

    //print a list of the options that the user has
    private void printList() {
        System.out.println("-----List of Options-----");
        System.out.println("-Add Card-(1)");
        System.out.println("-View Card-(2)");
        System.out.println("-View Card List-(3)");
        System.out.println("-To Exit Application-(4)");
        System.out.println("-To view list of Options-(5)");
        System.out.println("-Edit Card-(6)");
        System.out.println("-------------------------");

    }

    private void editCardInterface(){
        System.out.println("Are you sure that you want to EDIT a card?(y/n)");
        String confirmation = reader2.next();
        if (confirmation.toLowerCase().equals("y")) {
            System.out.println("Enter Title of Card to Edit");
            String CardTitle = title.nextLine();
            boolean inList = false;
            for (int p=0; p<list.getCardCount(); p++) {
                if (list.getCard(p).getTitle().equals(CardTitle)) {
                    inList = true;
                }
            }
            if (inList==true) {

                System.out.println("-----List of Fields-----");
                System.out.println("-Title-(1)");
                System.out.println("-Priority-(2)");
                System.out.println("-Description-(3)");
                System.out.println("-Deadline-(4)");
                System.out.println("-Color-(5)");
                System.out.println("-------------------------\n");
                System.out.println("Select Card Field to Change");

                int field = reader2.nextInt();

                switch (field) {
                    case 1://Title
                        System.out.println("You selected to change the TITLE of the following card: "+CardTitle);
                        System.out.println("Please enter the new title for this card");
                        String newTitle = reader3.nextLine();
                        System.out.println("----------------------------------------------------");
                        list.getCard(CardTitle).changeTitle(newTitle);
                        break;

                    case 2://Priority
                        System.out.println("You selected to change the PRIORITY of the following card: "+CardTitle);
                        System.out.println("The current priority of this card is: "+list.getCard(CardTitle).getPriority());
                        System.out.println("Please enter the new priority for this card");
                        int newPriority = reader2.nextInt();
                        System.out.println("----------------------------------------------------");
                        list.getCard(CardTitle).changePriority(newPriority, list.getCardCount());//Change priority in card
                        list.changePriority(list.getCard(CardTitle), newPriority);//Change priority in workspace
                        break;

                    case 3://Description
                        System.out.println("You selected to change the DESCRIPTION of the following card: "+CardTitle);
                        System.out.println("The current description of this card is: "+list.getCard(CardTitle).getDescription());
                        System.out.println("Please enter the new description for this card");
                        String newDescription = reader3.nextLine();
                        System.out.println("----------------------------------------------------");
                        list.getCard(CardTitle).changeDescription(newDescription);
                        break;

                    case 4://Deadline
                        System.out.println("You selected to change the DEADLINE of the following card: "+CardTitle);
                        System.out.println("The current deadline of this card is: "+list.getCard(CardTitle).getDeadline());
                        System.out.println("Please enter the new deadline for this card");
                        String newDeadline = reader3.nextLine();
                        System.out.println("----------------------------------------------------");
                        list.getCard(CardTitle).changeDeadline(newDeadline);
                        break;
                    case 5: //Color Field
                        System.out.println("You selected to change the COLOR of the following card: "+CardTitle);
                        System.out.println("The current color of this card is: "+list.getCard(CardTitle).getColor());
                        System.out.println("Please enter the new deadline for this card");
                        String newColor = color.nextLine().toLowerCase();
                        System.out.println("----------------------------------------------------");
                        list.getCard(CardTitle).changeColor(newColor);
                        break;
                    default:
                        System.out.println("The choice selected is invalid");

                }
            }

            else{
                    System.out.println(CardTitle+" is not found in the Workspace.\n\n");
                }


            } else {
            Options();
        }
    }

    public static void main(String[] args) {
       UserInterface start = new UserInterface();
       start.Options();
    }
}




