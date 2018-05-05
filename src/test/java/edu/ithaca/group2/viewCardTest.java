package edu.ithaca.group2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class viewCardTest {

    @Test
    void getTitleTest() {

        String string = "one";
        int num = 1;
        String description = "This is the description for card titled one, with priority 1, and deadline is tomorrow.";
        String deadline = "11/22/2018";
        String color = "red";
        Card card1 = new Card(string, num, description, deadline, color );
        String stringExpected = "one";
        String stringActual = card1.getTitle();
        Assert.assertEquals(stringExpected, stringActual);

        string = "two";
        Card card2 = new Card(string, num, description, deadline, color );
        stringExpected = string;
        stringActual = card2.getTitle();
        Assert.assertEquals(stringExpected, stringActual);

    }

    @Test
    void getPriorityTest() {
        String string = "one";
        int num = 1;
        String description = "This is the description for card titled one, with priority 1, and deadline is tomorrow.";
        String deadline = "11/22/2018";
        String color = "red";
        Card card1 = new Card(string, num, description, deadline, color );
        int intExpected = 1;
        int intActual = card1.getPriority();
        Assert.assertEquals(intExpected, intActual);

        num = 2;
        Card card2 = new Card(string, num, description, deadline, color );
        intExpected = 2;
        intActual = card2.getPriority();
        Assert.assertEquals(intExpected, intActual);

    }

    @Test
    void getDescriptionTest() {

        String string = "one";
        int num = 1;
        String description = "This is the description for card titled one, with priority 1, and deadline is tomorrow.";
        String deadline = "11/22/2018";
        String color = "red";
        Card card1 = new Card(string, num, description, deadline, color );
        String stringExpected = description;
        String stringActual = card1.getDescription();
        Assert.assertEquals(stringExpected, stringActual);

        description = "second description";
        Card card2 = new Card(string, num, description, deadline, color );
        stringExpected = description;
        stringActual = card2.getDescription();
        Assert.assertEquals(stringExpected, stringActual);

    }

    @Test
    void getDeadlineTest() {
        String string = "one";
        int num = 1;
        String description = "This is the description for card titled one, with priority 1, and deadline is tomorrow.";
        String deadline = "11/22/2018";
        String color = "red";
        Card card1 = new Card(string, num, description, deadline, color );
        //Date dateExpected =new Date(118,10,22);
        String dateactual = card1.getDeadline();
        Assert.assertEquals("11/22/2018", dateactual);

        deadline = "two";
        Card card2 = new Card(string, num, description, deadline, color );
        String stringActual= card2.getDeadline();
        Assert.assertEquals("two", stringActual);

    }

    @Test
    void viewCardTest(){

        String title = "Title one";
        int priority = 1;
        String description = "Description 1.";
        String deadline = "11/12/2018";
        String color = "red";
        Card card1 = new Card(title, priority,description,deadline, color);
        Date testdate =new Date(118,10,12);

        String expectedViewCard = title+"\nID: "+priority+"\n\t"+description+"\nDeadline: "+testdate+"\nCard Color:"+ color;
        Assert.assertEquals(expectedViewCard,card1.viewCard());

        title ="title";
        priority = 1;
        String deadline2 = "";
        description = "";
        color = "white";
        Card card2 = new Card(title, priority,deadline2,description,color);
        Date testdate2 =new Date(0,0,0);

        expectedViewCard = title+"\nID: "+priority+"\nDeadline: " + testdate2  + "\nCard Color:"+ color;
        //title + "\nID: " + priority + "\nDeadline: " + deadline  + "\nCard Color:"+ color;

        Assert.assertEquals(expectedViewCard,card2.viewCard());

        title ="";
        priority = 0;
        deadline = "";
        description = "";
        color = "red";
        Card card3 = new Card(title,priority,description, deadline,color);

        expectedViewCard = title+"\nID: "+priority+"\nDeadline: " + testdate2  +"\nCard Color:"+ color;

        Assert.assertEquals(expectedViewCard,card3.viewCard());

        title ="title";
        priority = 1;
        deadline = "";
        description = "";
        color = "blue";
        Card card4 = new Card(title, priority, description, deadline, color);
        expectedViewCard = title+"\nID: "+priority+"\nDeadline: " + testdate2 +"\nCard Color:"+ color;
        Assert.assertEquals(expectedViewCard,card4.viewCard());

        title ="title";
        priority = 1;
        deadline = "11/28/2018";
        description = "";

        Card card5 = new Card(title, priority, description, deadline, color);
        Date deadlinea=new Date(118,10,28);
        expectedViewCard = title+"\nID: "+priority+ "\nDeadline: "+deadlinea+"\nCard Color:"+ color;
        Assert.assertEquals(expectedViewCard,card5.viewCard());
        System.out.println(card1.viewCard()+"\n_______\n"+card2.viewCard()+"\n_______\n"+card3.viewCard()+"\n_______\n"+card4.viewCard()+"\n_______\n"+card5.viewCard());
    }
    @Test
    void QuantDateTest() {
        Card card1=new Card("Title", 0,"stuff","4/11/2018","pink");
        Card card2 = new Card("Title", 1,"description","5/31/2017","green");
        String deadline = card1.getDeadline();
        String deadline2 = card2.getDeadline();
        System.out.println(deadline);
        assertEquals(deadline,card1.getDeadline());
        System.out.println(deadline2);
        assertEquals(deadline2,card2.getDeadline());


    }
    @Test
    void NotifTest(){
        Card test1 =new Card("title1",0,"things","5/15/2018","green");
        Card test2 =new Card("title2",1,"things","5/13/2018","green");
        Card test3 =new Card("title3",2,"things","5/12/2018","green");
        Card test3a =new Card("title3",2,"things","5/12/2018","green");
        Card test3b =new Card("title3",2,"things","5/12/2018","green");
        Card test4 =new Card("title4",3,"things","5/05/2018","green");
        Card test5 =new Card("title5",4,"things","5/04/2018","green");
        Workspace testw=new Workspace();

        testw.addCard(test1);
        testw.addCard(test2);
        testw.addCard(test3);
        testw.addCard(test4);
        testw.addCard(test5);
        testw.addCard(test3a);
        testw.addCard(test3b);

        String testd = "5/12/18";
        String testd2 ="5/24/18";

        String message= "Your "+test1.getTitle()+" "+test2.getTitle()+" "+test3.getTitle()+" "+test3a.getTitle()+" "+test3b.getTitle()+" "+"cards are upcoming";
        String message2= "Your "+test3.getTitle()+" "+test3a.getTitle()+" "+test3b.getTitle()+" "+"cards are upcoming";
        String message3= "No Cards are upcoming";
        
        //Test for regular use
        assertEquals(message,testw.dateNotifiation(5,testd));
        //Test for if the notification is on the same day
        assertEquals(message2,testw.dateNotifiation(0,testd));
        //Test if No Cards for the notification
        assertEquals(message3,testw.dateNotifiation(9,testd2));

    }
}