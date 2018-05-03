package edu.ithaca.group2;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class UserInterface {

    //TODO: Change this page to the following format

    //While loop of Options
    //Options have switch case which calls __Interface() functions
    //__Interface() functions collect user input
    //__Interface() functions call __Function(params) functions with params from user input

    private Scanner reader = new Scanner(System.in);

    private boolean flag = true;

    private Workspace list = new Workspace();

    private void changeFlag() {
        flag = false;
    }
    //user makes selection from the list

    /**
     * Contains while loop which runs until the program is terminated
     *
     * @return 0 when program ends
     */
    private int Options() {
        //implementing scanner
        Scanner reader1 = new Scanner(System.in);

        System.out.println("\n Hello user,");
        System.out.println("How may I be of assistance to you today?");
        printList();

        //first instance of the CardList


        while (flag) {
            System.out.println("Which task do you want to accomplish?(1-9) \n");

            int choice = reader1.nextInt();
            reader1.nextLine();


            switch (choice) {

                case 1: //add Card
                    addNewCardSimple();
                    break;
                case 2: //View a Card
                    viewCardInterface();
                    break;

                case 3: //Print all Cards(finish later)
                    System.out.println("Are you sure that you want to VIEW the CARD LIST?(y/n)");
                    String confirmation = reader.nextLine();
                    if (confirmation.toLowerCase().equals("y")) {
                        System.out.println("\nCard List:");
                        System.out.println(list.viewAllCards());
                        System.out.println("\n\n");
                        break;
                    }
                    break;

                case 4: //Quit
                    System.out.println("Are you sure that you want to QUIT?(y/n)");
                    confirmation = reader.nextLine();
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
                case 7://Delete Card
                    deleteCardInterface();
                    break;
                case 8://Save Workspace to file
                    saveWorkspaceToFile();
                    break;
                case 9:
                    readInWorkspace();
                    break;
                default:
                    System.out.println("The choice selected is invalid. Try again");
                    System.out.println("If you want a list of possible actions, press 5 when prompted");
                    System.out.println("-------------------------------------------------------------");
                    printList();

            }

        }

        return 0;
    }

    //case 1 NOT USED
    private void addCardInterface() {
        System.out.println("Are you sure that you want to ADD a card?(y/n)");
        //String confirmation = reader.next();
        String confirmation = reader.nextLine();
        if (confirmation.toLowerCase().equals("y")) {

            System.out.println("Enter your Title: \n");
            String CardTitle = reader.nextLine();
            System.out.println("--------------------");

            System.out.println("Enter the priority for this card:(0-10)");
            int CardPriority = reader.nextInt();
            reader.nextLine();
            System.out.println("----------------------------------------");

            System.out.println("Provide a description for the card(This is optional)");
            String CardDescription = reader.nextLine();
            System.out.println("----------------------------------------------------");

            System.out.println("When is your deadline?");
            String CardDeadline = reader.nextLine();
            System.out.println("----------------------------------------------------");

            System.out.println("Select a color");
            String CardColor = reader.nextLine();
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

    /**
     * Collects info for adding a card
     * Calls addCard() to add card to workspace
     *
     * @return void
     */
    private void addNewCardSimple(){
        String CardColor = "white"; //default
        String CardDeadline = ""; //Default
        String CardDescription = ""; //Default
        System.out.println("Are you sure that you want to ADD a card?(y/n)\n");
        //String confirmation = reader.next();
        String confirmation = reader.nextLine();
        if (confirmation.toLowerCase().equals("y")) {

            System.out.println("Enter your Title: \n");
            String CardTitle = reader.nextLine();
            System.out.println("--------------------");

            System.out.println("Enter the priority for this card:");
            int CardPriority = reader.nextInt();
            reader.nextLine();
            System.out.println("----------------------------------------");

            boolean changeFields = false;
        System.out.println("Would you like to add more fields? (y/n)\n");
        String newConfirmation = reader.nextLine();
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
            int field = reader.nextInt();
            reader.nextLine();

            switch(field) {

                case 1:
                    System.out.println("Provide a description for the card:");
                    CardDescription = reader.nextLine();
                    System.out.println("----------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Provide a deadline for the card:");
                    CardDeadline = reader.nextLine();
                    System.out.println("----------------------------------------------------");
                    break;
                case(3):
                    System.out.println("Select a color for your card");
                    CardColor = reader.nextLine().toLowerCase();
                    System.out.println("----------------------------------------------------");
                    break;
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

    /**
     * Collects info about which card is being viewed
     * calls viewCard() to view the chosen card
     *
     * @return void
     */
    //case2
    private void viewCardInterface() {
        System.out.println("Are you sure that you want to VIEW a card?(y/n)");
        String confirmation = reader.nextLine();
        if (confirmation.toLowerCase().equals("y")) {
            System.out.println("Enter Card Title");
           String CardTitle = reader.nextLine();
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

    /**
     * Prints commandLine options
     *
     * @return void
     */
    //print a list of the options that the user has
    private void printList() {
        System.out.println("-----List of Options-----");
        System.out.println("-Add Card-(1)");
        System.out.println("-View Card-(2)");
        System.out.println("-View Card List-(3)");
        System.out.println("-To Exit Application-(4)");
        System.out.println("-To view list of Options-(5)");
        System.out.println("-Edit Card-(6)");
        System.out.println("-Delete Card-(7)");
        System.out.println("-Write-out/ Save workspace-(8)");
        System.out.println("-Read-in / open a saved workspace-(9)");
        System.out.println("-------------------------");

    }

    /**
     * Collects info about which card is being edited
     * collects info about which fields to edit
     * changes field(s) in card
     *
     * @return void
     */
    private void editCardInterface(){
        System.out.println("Are you sure that you want to EDIT a card?(y/n)");
        String confirmation = reader.nextLine();
        if (confirmation.toLowerCase().equals("y")) {
            System.out.println("Enter Title of Card to Edit");
            String CardTitle = reader.nextLine();
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
                int field = reader.nextInt();
                reader.nextLine();

                switch (field) {
                    case 1://Title
                        System.out.println("You selected to change the TITLE of the following card: "+CardTitle);
                        System.out.println("Please enter the new title for this card");
                        String newTitle = reader.nextLine();
                        System.out.println("----------------------------------------------------");
                        list.getCard(CardTitle).changeTitle(newTitle);
                        break;

                    case 2://Priority
                        System.out.println("You selected to change the PRIORITY of the following card: "+CardTitle);
                        System.out.println("The current priority of this card is: "+list.getCard(CardTitle).getPriority());
                        System.out.println("Please enter the new priority for this card");
                        int newPriority = reader.nextInt();
                        reader.nextLine();
                        System.out.println("----------------------------------------------------");
                        list.changePriority(list.getCard(CardTitle), newPriority);//Change priority in workspace
                        break;

                    case 3://Description
                        System.out.println("You selected to change the DESCRIPTION of the following card: "+CardTitle);
                        System.out.println("The current description of this card is: "+list.getCard(CardTitle).getDescription());
                        System.out.println("Please enter the new description for this card");
                        String newDescription = reader.nextLine();
                        System.out.println("----------------------------------------------------");
                        list.getCard(CardTitle).changeDescription(newDescription);
                        break;

                    case 4://Deadline
                        System.out.println("You selected to change the DEADLINE of the following card: "+CardTitle);
                        System.out.println("The current deadline of this card is: "+list.getCard(CardTitle).getDeadline());
                        System.out.println("Please enter the new deadline for this card");
                        String newDeadline = reader.nextLine();
                        System.out.println("----------------------------------------------------");
                        list.getCard(CardTitle).changeDeadline(newDeadline);
                        break;
                    case 5: //Color Field
                        System.out.println("You selected to change the COLOR of the following card: "+CardTitle);
                        System.out.println("The current color of this card is: "+list.getCard(CardTitle).getColor());
                        System.out.println("Please enter the new deadline for this card");
                        String newColor = reader.nextLine().toLowerCase();
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

    /**
     * Collects info about which card is being deleted
     * calls deleteCard() to delete card
     *
     * @return void
     */
    private void deleteCardInterface(){
        System.out.println("Which card would you like to delete: \n");
        String titleToDelete = reader.nextLine();
        int priorityToDelete = -1;
        for (int i = 0; i<list.cardCount; i++){
            if (list.getCard(i).getTitle().equals(titleToDelete))
            {
                priorityToDelete = i;
            }
        }
        if (priorityToDelete == -1){
            System.out.println("\nSorry, this card could not be found\n");
        }
        else{
            Card toDelete = list.getCard(priorityToDelete);
            list.deleteCard(toDelete);
            System.out.println("Card: "+titleToDelete+" has been deleted\n");
        }
    }

    private String saveWorkspaceToFile(){
        String fileName = "src/test/resources/writeInAndOutTest.json";
        try{
            ReadInWriteOut.writeToJson(list, fileName);
            System.out.println("Success!");
            return fileName;
        }
        catch(IOException e){
            return "Either nothing is in the workspace, or you have a corrupted filepath.";
        }
    }

    private void readInWorkspace(){
        String fileName = "src/test/resources/writeInAndOutTest.json";
        try {
            list = ReadInWriteOut.buildCardFromJson(fileName);
            System.out.println("Success");
        }
        catch(IOException e){
            System.out.println("404: File Not Found");
        }
    }

    public static void main(String[] args) {
       UserInterface start = new UserInterface();
       start.Options();
       System.out.println("\nProgram is terminating");
       System.out.println("-------------------------------------------------------------");
    }
}




