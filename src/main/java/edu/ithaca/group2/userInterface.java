package edu.ithaca.group2;
import java.util.*;

public class userInterface {

    private Scanner reader2 = new Scanner(System.in);
    private Scanner title = new Scanner(System.in);
    private Scanner priority = new Scanner(System.in);
    private Scanner description = new Scanner(System.in);
    private Scanner deadline = new Scanner(System.in);
    private boolean flag = true;

    private Workspace list = new Workspace();


    private void changeFlag() {
        flag = false;
    }
    //user makes selection from the list

    int Options() {
        //implementing scanner
        Scanner reader1 = new Scanner(System.in);

        System.out.println("\n Hello user,");
        System.out.println("How may I be of assistance to you today?");
        printList();

        //first instance of the CardList


        while (flag) {
            System.out.println("Which task do you want to accomplish?(1-5) \n");

            int choice = reader1.nextInt();


            switch (choice) {
                //calls the addCardFucntion
                case 1:
                    addCardInterface();
                    break;
                case 2:
                    //View a Card
                    viewCardInterface();
                    break;
                //do this one later
                case 3:
                    System.out.println("Are you sure that you want to VIEW the CARD LIST?(y/n)");
                    String confirmation = reader2.next();
                    if (confirmation.toLowerCase().equals("y")) {
                        System.out.println("You can View card list now");
                        break;
                    }
                case 4:
                    System.out.println("Are you sure that you want to QUIT?(y/n)");
                    confirmation = reader2.next();
                    if (confirmation.toLowerCase().equals("y")) {
                        System.out.println("You can quit the application");
                        changeFlag();
                        break;
                    }
                    break;
                case 5:

                    printList();
                    break;
                default:
                    System.out.println("The choice selected is invalid. Try again");
                    System.out.println("If you want a list of possible actions, press 5 when prompted");
                    System.out.println("-------------------------------------------------------------");
                    return -1;

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


            Card newCard = new Card(CardTitle, CardPriority, CardDescription, CardDeadline);
            list.addCard(newCard);

            //newCard.viewCard();

            System.out.println("You have added a card successfully");
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
            System.out.println("Enter Card Priority");
           String CardTitle = title.nextLine();
            list.getCard(CardTitle).viewCard();


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
        System.out.println("-------------------------");

    }

    public static void main(String[] args) {
       userInterface start = new userInterface();
       start.Options();
    }
}




