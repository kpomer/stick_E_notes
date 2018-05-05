package edu.ithaca.group2;


import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Card {

    String title;
    int priority = 0;

    String description = "";
    Date deadline;
    String color = "white";

    //default constructor
    public Card(){
        //A card only needs a title and a priority, however, it can also have a description and a deadline.
        this.title = "";
        this.priority = 0;

        this.description = "";
        this.deadline = new Date(0,0,0);
        this.color = "white";
    }

    //constructor if only title and priority are given
    public Card(String title, int priority){
        this.title = title;
        this.priority = priority;

        this.description = "";
        this.deadline = new Date(0,0,0);

        this.color = "white";
        //I don't think it should say "no description yet" or "no card yet" because these fields may never be filled
        //In my opinion it looks cleaner to leave them as empty strings
    }

    //constructor if all data members are given
    public Card(String title, int priority, String description, String deadline, String color){
        this.title= title;
        this.priority = priority;

        this.description = description;
        this.deadline = strTodate(deadline);
        this.color = color.toLowerCase();
    }
    public Date strTodate(String deadline){
        SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy");
        //String input = args.length == 0 ? "1818-11-11" : args[0];
        //System.out.print(deadline + " Parses as ");
        Date blank= new Date(0,0,0);
        Date t;
        try {
            t = ft.parse(deadline);
            //System.out.println("From function "+t);
            SimpleDateFormat dt1 = new SimpleDateFormat("MM/dd/yyyy");
            //System.out.println(dt1.format(t));
            return t;
        } catch (ParseException e) {
            //System.out.println("You've entered an improper String, " + ft);
            System.out.println("Your Date is 12/31/1899");
            return blank;
        }
        //return null;
        /*Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        deadline = formatter.format(date);
        System.out.println("Date Format with MM/dd/yyyy : "+deadline);
        return date;*/
    }
   /*  public String dateTostr(Date deadline){
         // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date (month/day/year)
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        // Get the date today using Calendar object.
         Date today = deadline;
        // Using DateFormat format method we can create a string
        // representation of a date with the defined format.
         String reportDate = df.format(today);

        // Print what date is today!
         //System.out.println("Report Date: " + reportDate);
         return reportDate;
     }*/


    public void changeTitle(String newTitle){
        setTitle(newTitle);
    }

    public void changePriority(int priority, int cardCount){
        if (priority<=(cardCount-1) && priority>=0){
            setPriority(priority);
        }

    }

    //changers

    public void changeDescription(String newDescription){
        setDescription(newDescription);
    }

    public void changeDeadline(String newDeadline){
        setDeadline(newDeadline);
    }

    public void changeColor( String newColor){ setColor(newColor);}

    //setting

    public void setColor(String color){this.color = color;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(String deadline) {
        Date date = strTodate(deadline);
        this.deadline = date;
    }

    //getters

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getColor(){return color;}

    /**
     * Returns String of a card in printout format
     * @param
     * @return String of formated Card info
     */
    public String viewCard(){
        Format formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strdeadline = formatter.format(deadline);
        //String blank="";

        if(strdeadline.equals("12/31/1899"))
            strdeadline = "";
        if(description.equals("") && deadline.equals("")){
            return title + "\nID: " + priority + "\nCard Color:"+ color;
        }else if(description.equals("")){
            return title + "\nID: " + priority + "\nDeadline: " + deadline  + "\nCard Color:"+ color;
        }else if(deadline.equals("")){
            return title + "\nID: " + priority + "\n\t" + description  + "\nCard Color:"+ color;
        }else {
            return title + "\nID: " + priority + "\n\t" + description + "\nDeadline: " + deadline + "\nCard Color:"+ color;
        }
        // if Date shws up as default date
        // turn into a blank string
        //Make another function that turns string that cant be turned into Dtaes into Blank dates abd returns them


    }


}
