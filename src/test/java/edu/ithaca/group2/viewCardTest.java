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
        String deadline = "11/22/18 - 9:00 pm";
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
        String deadline = "11/22/18 - 9:00 pm";
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
        String deadline = "11/22/18 - 9:00 pm";
        Card card1 = new Card(string, num, description, deadline );
        String stringExpected = deadline;
        String stringActual = card1.getDeadline();
        Assert.assertEquals(stringExpected, stringActual);

        deadline = "two";
        Card card2 = new Card(string, num, description, deadline );
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
        Card card1 = new Card(title, priority,description,deadline);

        String expectedViewCard = "Title: "+title+"\nID: "+priority+"\n\t"+"Description: "+description+"\nDeadline: "+deadline;
        Assert.assertEquals(expectedViewCard,card1.viewCard());

        title ="title";
        priority = 1;
        deadline = "";
        description = "";
        Card card2 = new Card(title, priority);
        expectedViewCard = "Title: "+title+"\nID: "+priority+"\n\t"+"Description: "+description+"\nDeadline: "+deadline;
        Assert.assertEquals(expectedViewCard,card2.viewCard());

        title ="";
        priority = 0;
        deadline = "";
        description = "";
        Card card3 = new Card();
        expectedViewCard = "Title: "+title+"\nID: "+priority+"\n\t"+"Description: "+description+"\nDeadline: "+deadline;
        Assert.assertEquals(expectedViewCard,card3.viewCard());

        System.out.println(card1.viewCard()+"\n_______\n"+card2.viewCard()+"\n_______\n"+card3.viewCard());
    }
}