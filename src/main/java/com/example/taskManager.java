
package com.example;

//Import libraries
import java.util.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.Files.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class taskManager {

    private List<Task> tasks = new ArrayList<>();
    private Path path = Paths.get("C:\\dev\\projects\\textToolKit-maven\\tasks.txt");

    // No arg constructor
    public taskManager() {

    }

    // Methods

    // add a task to the list
    public void addTask(String description) {
        Task t = new Task(description);
        tasks.add(t);
    }

    public void addTask(int id, String description, boolean status) {
        Task t = new Task(id, description, status);
        tasks.add(t);
    }

    // Remove a task from the list
    public void removeTask(int id) {
        Iterator<Task> iterator = tasks.iterator();

        while (iterator.hasNext()) {
            Task task = iterator.next();

            if (task.getId() == id) {
                iterator.remove(); // safe iterator removal
                System.out.println("Task " + id + " has been removed");
                return; // Stop after removing
            }
        }

        System.out.println("Task with ID " + id + " not found");
    }

    // Print out a list of the tasks to the console;
    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet!");

        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    // Find task in the list and mark it complete
    public void completeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markComplete();
                return;
            }
        }
        System.out.println("Task with ID " + id + " not found.");
    }

    // ---------------------------------------------------------------------------------
    // Getter Methods

    // Get size
    public int getSize() {
        return tasks.size();
    }

    // Get task by index
    public Task getTask(int index) {
        return tasks.get(index);
    }

    // Get Task by ID
    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    // Get a list of tasks
    public List<Task> listTasks() {
        return new ArrayList<>(tasks);
    }

    // ---------------------------------------------------------------------------------
    // File Persistence Methods

    public void saveTasks() {
        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            sb.append(task.getId())
                    .append("|")
                    .append(task.getDescription())
                    .append("|")
                    .append(task.isCompleted())
                    .append("\n");
        }

        try {
            Files.writeString(path, sb, StandardCharsets.UTF_8);

        }

        catch (IOException ex) {
            System.out.println("Error saving tasks: " + ex.getMessage());
        }

    }

    public List<Task> loadTasks() {

        // Catch FileNotFound Exception
        try (Scanner inFile = new Scanner(path, StandardCharsets.UTF_8)) {

            while (inFile.hasNext()) {
                String record = inFile.nextLine();
                String[] tokens = record.split("\\|");

                if (tokens.length != 3) {
                    System.out.println("Skipping bad line: " + record);
                    continue; //skip to next line
                }

                try{
                    int id = Integer.parseInt(tokens[0]);
                    String description = tokens[1];
                    boolean status = Boolean.parseBoolean(tokens[2]);

                    this.addTask(id, description, status);

                } catch (NumberFormatException e){
                    System.out.println("Invalid number in line: " + record);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return tasks;
    }

}
