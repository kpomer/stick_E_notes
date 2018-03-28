package edu.ithaca.group2;


public class Card {

    String title;
    int priority = 0;

    String description = "";
    String deadline = "";

    //default constructor
    public Card(){
        //A card only needs a title and a priority, however, it can also have a description and a deadline.
        this.title = "Untitled Card";
        this.priority = 0;

        this.description = "no description yet";
        this.deadline = "no deadline yet";
    }

    //constructor if only title and priority are given
    public Card(String title, int priority){
        this.title = title;
        this.priority = priority;

        this.description = "no description yet";
        this.deadline = "no deadline yet";
    }

    //constructor if all data members are given
    public Card(String title, int priority, String description, String deadline){
        this.title= title;
        this.priority = priority;

        this.description = description;
        this.deadline = deadline;
    }

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
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public String viewCard(){

        return title+"\nID: "+priority+"\n\t"+description+"\nDeadline: "+deadline;
    }
}
