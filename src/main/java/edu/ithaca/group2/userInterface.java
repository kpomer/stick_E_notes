package edu.ithaca.group2;
import java.util.*;

public class userInterface {
    private boolean flag = true;

    private void changeFlag(){
        flag = false;
    }
    //user makes selection from the list
    int Options(int choice){
        //implementing scanner
        Scanner reader1 = new Scanner(System.in);
        Scanner reader2 = new Scanner(System.in);
        System.out.println("Hello user,");
        System.out.println("How may I be of assistance to you today?");
        printList();

        while(flag){
            System.out.println("What task do you want to accomplish? \n");

              //int choice = reader.nextInt();


            switch(choice){
                //calls the addCardFucntion
                case 1:
                    System.out.println("Are you sure that you want to ADD a card?(y/n)");
                    //String confirmation = reader2.next();
                    String confirmation = "Y";
                    if(confirmation.toLowerCase().equals("y")){
                        //call teh function
                        System.out.println("You have added a card");
                        changeFlag();
                        break;
                    }
//                    changeFlag();
//                    break;
                case 2:
                    System.out.println("Are you sure that you want to VIEW a card?(y/n)");
                    confirmation = reader2.next();
                    if(confirmation.toLowerCase().equals("y")) {
                        System.out.println("you can view cards now");
                        break;
                    }
                case 3:
                    System.out.println("Are you sure that you want to VIEW the CARD LIST?(y/n)");
                    confirmation = reader2.next();
                    if(confirmation.toLowerCase().equals("y")) {
                        System.out.println("You can View card list now");
                        break;
                    }
                case 4:
                    System.out.println("Are you sure that you want to QUIT?(y/n)");
                    confirmation = reader2.next();
                    if(confirmation.toLowerCase().equals("y")) {
                        System.out.println("You can quit the application");
                        changeFlag();
                        break;
                    }
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

        return 0;
    }

    //print a list of the options that the user has
   private  void  printList(){
        System.out.println("-----List of Options-----");
        System.out.println("-Add Card-(1)");
        System.out.println("-View Card-(2)");
        System.out.println("-View Card List-(3)");
        System.out.println("-To Exit Application-(4)");
        System.out.println("-To view list of Options-(5)");
        System.out.println("-------------------------");

    }


}
