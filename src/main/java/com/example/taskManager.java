
package com.example;

//Import libraries
import java.util.*;

public class taskManager {

    private List<Task> tasks = new ArrayList<>();

    //No arg constructor
    public taskManager(){

    }


    //Methods

    //add a task to the list
    public void addTask(String description){
        Task t = new Task(description);
        tasks.add(t);
    }
    

    //Remove a task from the list 
    public void removeTask(int id){
        Iterator<Task> iterator = tasks.iterator();
        
        while(iterator.hasNext()){
            Task task = iterator.next();

            if(task.getId() == id){
                iterator.remove(); // safe iterator removal
                System.out.println("Task " + id + " has been removed");
                return; //Stop after removing
            }
        }

        System.out.println("Task with ID " + id + " not found");
    }

    //Print out a list of the tasks to the console;
    public void printTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks yet!");

        }else{
            for(Task task : tasks){
                System.out.println(task);
            }
        }
    }


    //Find task in the list and mark it complete
    public void completeTask(int id){
        for(Task task : tasks){
            if(task.getId() == id){
                task.markComplete();
                return;
            }
        }
        System.out.println("Task with ID " + id + " not found.");
    }


    //---------------------------------------------------------------------------------
    //Getter Methods

    //Get size
    public int getSize(){
        return tasks.size();
    }

    //Get task by index
    public Task getTask(int index){
        return tasks.get(index);
        }

    //Get Task by ID
    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
            return task;
        }
    }
            return null;
}


        //Get a list of tasks
    public List<Task> listTasks(){
        return new ArrayList<>(tasks);
    }
    }
    


