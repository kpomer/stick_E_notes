package edu.ithaca.group2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class ReadInWriteOutTest {
//
//    @Test
//    void toJsonAndBackWithCardTest() {
//        Card card1 = new Card("title1",0,"card1 description", "04/09/2018");
//        Card card2 = new Card("title2",1);
//        Card card3 = new Card();
//        Card card4 = new Card("title4",3,"card4 description trying to make this really long... asdfhasdfhasdfhasdfhasdfh hasdfh hasdf hasdf hasdf hasdf hasdf hasdf ijjhsdfgjejejfmfmj", "04/12/2018");
//
//
//        try {
//            Card toFile = card1;
//            String fullFilename = "/Users/harrisonkesel/Documents/stick_E_notes/src/test/java/edu/ithaca/group2.json";
//            ReadInWriteOut.writeToJson(toFile, fullFilename);
//            Card fromFile = ReadInWriteOut.buildCardFromJson(fullFilename);
////            System.out.println(toFile.viewCard());
////            System.out.println(fromFile.viewCard());
//            assertEquals(toFile.getTitle(), fromFile.getTitle());
//            assertEquals(toFile.getPriority(), fromFile.getPriority());
//            assertEquals(toFile.getDescription(), fromFile.getDescription());
//            assertEquals(toFile.getDeadline(), fromFile.getDeadline());
//        }
//        catch (IOException e){
//            fail(e);
//        }
//
//        try {
//            Card toFile = card2;
//            String fullFilename = "/Users/harrisonkesel/Documents/stick_E_notes/src/test/java/edu/ithaca/group2.json";
//            ReadInWriteOut.writeToJson(toFile, fullFilename);
//            Card fromFile = ReadInWriteOut.buildCardFromJson(fullFilename);
////            System.out.println(toFile.viewCard());
////            System.out.println(fromFile.viewCard());
//            assertEquals(toFile.getTitle(), fromFile.getTitle());
//            assertEquals(toFile.getPriority(), fromFile.getPriority());
//            assertEquals(toFile.getDescription(), fromFile.getDescription());
//            assertEquals(toFile.getDeadline(), fromFile.getDeadline());
//        }
//        catch (IOException e){
//            fail(e);
//        }
//
//        try {
//            Card toFile = card3;
//            String fullFilename = "/Users/harrisonkesel/Documents/stick_E_notes/src/test/java/edu/ithaca/group2.json";
//            ReadInWriteOut.writeToJson(toFile, fullFilename);
//            Card fromFile = ReadInWriteOut.buildCardFromJson(fullFilename);
////            System.out.println(toFile.viewCard());
////            System.out.println(fromFile.viewCard());
//            assertEquals(toFile.getTitle(), fromFile.getTitle());
//            assertEquals(toFile.getPriority(), fromFile.getPriority());
//            assertEquals(toFile.getDescription(), fromFile.getDescription());
//            assertEquals(toFile.getDeadline(), fromFile.getDeadline());
//        }
//        catch (IOException e){
//            fail(e);
//        }
//
//        try {
//            Card toFile = card4;
//            String fullFilename = "/Users/harrisonkesel/Documents/stick_E_notes/src/test/java/edu/ithaca/group2.json";
//            ReadInWriteOut.writeToJson(toFile, fullFilename);
//            Card fromFile = ReadInWriteOut.buildCardFromJson(fullFilename);
////            System.out.println(toFile.viewCard());
////            System.out.println(fromFile.viewCard());
//            assertEquals(toFile.getTitle(), fromFile.getTitle());
//            assertEquals(toFile.getPriority(), fromFile.getPriority());
//            assertEquals(toFile.getDescription(), fromFile.getDescription());
//            assertEquals(toFile.getDeadline(), fromFile.getDeadline());
//        }
//        catch (IOException e){
//            fail(e);
//        }
//    }

    @Test
    void toJsonAndBackWithWorkspaceTest(){
        Card card1 = new Card("title1",0,"card1 description", "04/09/2018", "orange");
        Card card2 = new Card("title2",1);
        Card card3 = new Card("title3",2);
        Card card4 = new Card("title4",3,"card4 description trying to make this really long... asdfhasdfhasdfhasdfhasdfh hasdfh hasdf hasdf hasdf hasdf hasdf hasdf ijjhsdfgjejejfmfmj", "04/12/2018", "blue");

        Workspace ws1 = new Workspace();
        ws1.addCard(card1);
        ws1.addCard(card2);
        ws1.addCard(card3);
        ws1.addCard(card4);

        try {
            Workspace toFile = ws1;
            String fullFilename = "src/test/resources/writeInAndOutTest.json";
            ReadInWriteOut.writeToJson(toFile, fullFilename);
            Workspace fromFile = ReadInWriteOut.buildCardFromJson(fullFilename);
//            System.out.println(toFile.viewCard());
//            System.out.println(fromFile.viewCard());
            for (int i = 0; i < ws1.getCardCount(); i++) {
                assertEquals(toFile.getCardList().get(i).getTitle(), fromFile.getCardList().get(i).getTitle());
                assertEquals(toFile.getCardList().get(i).getPriority(), fromFile.getCardList().get(i).getPriority());
                assertEquals(toFile.getCardList().get(i).getDescription(), fromFile.getCardList().get(i).getDescription());
                assertEquals(toFile.getCardList().get(i).getDeadline(), fromFile.getCardList().get(i).getDeadline());
            }
            assertEquals(toFile.getCardCount(), fromFile.getCardCount());
        }
        catch (IOException e){
            fail(e);
        }
    }
}