package edu.ithaca.group2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class viewCardTest {

    @Test
    void getTitleTest() {

        String string = "one";
        int num = 1;
        String description = "This is the description for card titled one, with priority 1, and deadline is tomorrow.";
        String deadline = "11/22/18 - 9:00 pm";
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
        String deadline = "11/22/18 - 9:00 pm";
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
        String deadline = "11/22/18 - 9:00 pm";
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
        String deadline = "11/22/18 - 9:00 pm";
        String color = "red";
        Card card1 = new Card(string, num, description, deadline, color );
        String stringExpected = deadline;
        String stringActual = card1.getDeadline();
        Assert.assertEquals(stringExpected, stringActual);

        deadline = "two";
        Card card2 = new Card(string, num, description, deadline, color );
        stringExpected = deadline;
        stringActual = card2.getDeadline();
        Assert.assertEquals(stringExpected, stringActual);

    }

    @Test
    void viewCardTest(){

        String title = "Title one";
        int priority = 1;
        String description = "Description 1.";
        String deadline = "11/12/18 - 7:00 am ECT.";
        String color = "red";
        Card card1 = new Card(title, priority,description,deadline, color);

        String expectedViewCard = title+"\nID: "+priority+"\n\t"+description+"\nDeadline: "+deadline+"\nCard Color:"+ color;
        Assert.assertEquals(expectedViewCard,card1.viewCard());

        title ="title";
        priority = 1;
        deadline = "";
        description = "";
        color = "white";
        Card card2 = new Card(title, priority);

        expectedViewCard = title+"\nID: "+priority+"\nCard Color:"+ color;

        Assert.assertEquals(expectedViewCard,card2.viewCard());

        title ="";
        priority = 0;
        deadline = "";
        description = "";
        color = "red";
        Card card3 = new Card(title,priority,description, deadline,color);

        expectedViewCard = title+"\nID: "+priority+"\nCard Color:"+ color;

        Assert.assertEquals(expectedViewCard,card3.viewCard());

        title ="title";
        priority = 1;
        deadline = "";
        description = "";
        color = "blue";
        Card card4 = new Card(title, priority, description, deadline, color);
        expectedViewCard = title+"\nID: "+priority +"\nCard Color:"+ color;
        Assert.assertEquals(expectedViewCard,card4.viewCard());

        title ="title";
        priority = 1;
        deadline = "11/28/18";
        description = "";
        Card card5 = new Card(title, priority, description, deadline, color);
        expectedViewCard = title+"\nID: "+priority+ "\nDeadline: "+deadline+"\nCard Color:"+ color;
        Assert.assertEquals(expectedViewCard,card5.viewCard());

        System.out.println(card1.viewCard()+"\n_______\n"+card2.viewCard()+"\n_______\n"+card3.viewCard()+"\n_______\n"+card4.viewCard()+"\n_______\n"+card5.viewCard());
    }
}