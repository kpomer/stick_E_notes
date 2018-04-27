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
        String deadline = "11/22/18";
        Card card1 = new Card(string, num, description, deadline );
        String stringExpected = "one";
        String stringActual = card1.getTitle();
        Assert.assertEquals(stringExpected, stringActual);

        string = "two";
        Card card2 = new Card(string, num, description, deadline );
        stringExpected = string;
        stringActual = card2.getTitle();
        Assert.assertEquals(stringExpected, stringActual);

    }

    @Test
    void getPriorityTest() {
        String string = "one";
        int num = 1;
        String description = "This is the description for card titled one, with priority 1, and deadline is tomorrow.";
        String deadline = "11/22/18";
        Card card1 = new Card(string, num, description, deadline );
        int intExpected = 1;
        int intActual = card1.getPriority();
        Assert.assertEquals(intExpected, intActual);

        num = 2;
        Card card2 = new Card(string, num, description, deadline );
        intExpected = 2;
        intActual = card2.getPriority();
        Assert.assertEquals(intExpected, intActual);

    }

    @Test
    void getDescriptionTest() {

        String string = "one";
        int num = 1;
        String description = "This is the description for card titled one, with priority 1, and deadline is tomorrow.";
        String deadline = "11/22/18";
        Card card1 = new Card(string, num, description, deadline );
        String stringExpected = description;
        String stringActual = card1.getDescription();
        Assert.assertEquals(stringExpected, stringActual);

        description = "second description";
        Card card2 = new Card(string, num, description, deadline );
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
        Card card1 = new Card(string, num, description, deadline );
        Date dateExpected =new Date(118,10,22);
        Date dateactual = card1.getDeadline();
        Assert.assertEquals(dateExpected, dateactual);

        deadline = "two";
        Card card2 = new Card(string, num, description, deadline );
        //String stringExpected2 = deadline2;
        Date test =new Date(0,0,0);
        dateactual = card2.getDeadline();
        Assert.assertEquals(test, dateactual);

    }

    @Test
    void viewCardTest(){

        String title = "Title one";
        int priority = 1;
        String description = "Description 1.";
        String deadline = "11/12/2018";
        Card card1 = new Card(title, priority,description,deadline);
        Date testdate =new Date(118,10,12);

        String expectedViewCard = title+"\nID: "+priority+"\n\t"+description+"\nDeadline: "+testdate;
        Assert.assertEquals(expectedViewCard,card1.viewCard());

        title ="title";
        priority = 1;
        String deadline2 = "";
        description = "";
        Card card2 = new Card(title, priority);

        expectedViewCard = title+"\nID: "+priority;

        Assert.assertEquals(expectedViewCard,card2.viewCard());

        title ="";
        priority = 0;
        deadline = "";
        description = "";
        Card card3 = new Card();

        expectedViewCard = title+"\nID: "+priority;

        Assert.assertEquals(expectedViewCard,card3.viewCard());

        title ="title";
        priority = 1;
        deadline = "";
        description = "";
        Card card4 = new Card(title, priority, description, deadline);
        expectedViewCard = title+"\nID: "+priority;
        Assert.assertEquals(expectedViewCard,card4.viewCard());

        title ="title";
        priority = 1;
        deadline = "11/28/2018";
        description = "";
        Date deadlinea=new Date(118,10,28);
        Card card5 = new Card(title, priority, description, deadline);
        expectedViewCard = title+"\nID: "+priority+ "\nDeadline: "+deadlinea;
        Assert.assertEquals(expectedViewCard,card5.viewCard());

        System.out.println(card1.viewCard()+"\n_______\n"+card2.viewCard()+"\n_______\n"+card3.viewCard()+"\n_______\n"+card4.viewCard()+"\n_______\n"+card5.viewCard());
    }
    @Test
    void QuantDateTest() {
        Card card1=new Card("Title", 0,"stuff","4/11/2018");
        Card card2 = new Card("Title", 1,"description","5/31/2017");
        Date deadline = card1.getDeadline();
        Date deadline2 = card2.getDeadline();
        System.out.println(deadline);
        assertEquals(deadline,card1.getDeadline());
        System.out.println(deadline2);
        assertEquals(deadline2,card2.getDeadline());


    }
}