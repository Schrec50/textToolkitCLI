package com.example;
public class Task {
    
    //Fields
    private int id;
    private String description;
    private boolean completed;
    private static int counter = 1; //Static counter that lets variables increment

    //Argument Constructor
    public Task(String description){
        this.id = counter++;
        this.description = description;
        this.completed = false;
    }

    //---------------------------------------------------------------------------------
    public void markComplete(){
    this.completed = true;
    }

    public static void resetCounter() {
        counter = 1; // reset IDs (useful for tests)
    }

    @Override //Need this before every toString()
    public String toString(){
        return "Task " + this.id + ": " + this.description + 
         " | Status: " + (this.completed ? "Completed" : "Pending"); //Shorthand for If else in strings
    }

    //---------------------------------------------------------------------------------
    //Getter Methods
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    //---------------------------------------------------------------------------------
    //Setter Methods
    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    
    


}
