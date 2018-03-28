package edu.ithaca.group2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class veiwAllTest {
    @Test
    void veiwtest(){
        String title ="Do Laundry";
        int priority = 2;
        String desciption =" Wash your clothes today";
        String deadline = " Saturday";
        Card testcard= new Card(title,priority,desciption,deadline);

        String title2 ="Make Dinner";
        int priority2 = 3;
        String desciption2 ="Rice and Stew recipe";
        String deadline2 = "Friday";
        Card testcard2= new Card(title2,priority2,desciption2,deadline2);

        String title3 ="Club Football back";
        int priority3= 4;
        String desciption3 ="Barca is playing ";
        String deadline3 = "Saturday @ 2:45";
        Card testcard3= new Card(title3,priority3,desciption3,deadline3);
        Workspace testw = new Workspace();


        testw.addCard(testcard);
        testw.addCard(testcard2);
        testw.addCard(testcard3);
        System.out.println(testw.cardList);
        testw.veiwAllcards(testw.cardList);
        assertEquals("Do Laundry",title);
        assertEquals(3, priority2);
        assertEquals("Rice and Stew recipe",desciption2);
        assertEquals("Saturday @ 2:45",deadline3);

    }



}