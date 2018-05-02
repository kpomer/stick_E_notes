package edu.ithaca.group2;


public class Card {

    String title;
    int priority = 0;

    String description = "";
    String deadline = "";

    String color = "white";

    //default constructor
    public Card(){
        //A card only needs a title and a priority, however, it can also have a description and a deadline.
        this.title = "";
        this.priority = 0;

        this.description = "";
        this.deadline = "";
        this.color = "white";
    }

    //constructor if only title and priority are given
    public Card(String title, int priority){
        this.title = title;
        this.priority = priority;

        this.description = "";
        this.deadline = "";
        this.color = "white";
        //I don't think it should say "no description yet" or "no card yet" because these fields may never be filled
        //In my opinion it looks cleaner to leave them as empty strings
    }

    //constructor if all data members are given
    public Card(String title, int priority, String description, String deadline, String color){
        this.title= title;
        this.priority = priority;

        this.description = description;
        this.deadline = deadline;
        this.color = color.toLowerCase();
    }

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
        this.deadline = deadline;
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

    public String getDeadline() {
        return deadline;
    }

    public String getColor(){return color;}

    /**
     * Returns String of a card in printout format
     * @param
     * @return String of formated Card info
     */
    public String viewCard(){

        if(description.equals("") && deadline.equals("")){
            return title + "\nID: " + priority + "\nCard Color:"+ color;
        }else if(description.equals("")){
            return title + "\nID: " + priority + "\nDeadline: " + deadline  + "\nCard Color:"+ color;
        }else if(deadline.equals("")){
            return title + "\nID: " + priority + "\n\t" + description  + "\nCard Color:"+ color;
        }else {
            return title + "\nID: " + priority + "\n\t" + description + "\nDeadline: " + deadline + "\nCard Color:"+ color;
        }

    }
}
