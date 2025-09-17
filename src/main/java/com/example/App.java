package com.example;

import java.util.*;

/**
 * CLI TASK MANAGER
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        taskManager manager = new taskManager();
        int option = 0;
        String task;
        int taskID;

        while (option != 5) {
            System.out.println("Welcome to the CLI Task Manager!");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            if (k.hasNextInt()) {
                option = k.nextInt();
                if (option < 1 || option > 5) {
                    System.out.println("Invalid choice. Please select between 1 and 5.\n");
                    continue;
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.\n");
                k.next(); // clear bad input
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println();
                    k.nextLine();
                    System.out.print("Enter task name:  ");
                    task = k.nextLine();
                    manager.addTask(task);
                    System.out.println(task + " has been added to the task list.\n");
                    break;

                case 2:

                    System.out.println("\n----------------CLI Task List----------------");
                    manager.printTasks();
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Please enter the ID of the task you would like to remove: ");
                    k.nextLine();


                    taskID = -1;
                    while (!k.hasNextInt()) {
                        System.out.print("Please enter a valid numbered Task ID: ");
                        k.next();
                    }

                    taskID = k.nextInt();
                    k.nextLine();

                    manager.removeTask(taskID);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Please enter the ID of the task you would like to mark complete: ");
                    k.nextLine();

                    taskID = -1;
                    while (!k.hasNextInt()) {
                        System.out.print("Please enter a valid numbered Task ID: ");
                        k.next();
                    }

                    taskID = k.nextInt();
                    k.nextLine();

                    manager.completeTask(taskID);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Exiting Task Manager. Goodbye!");

                    break;

                default:
                    System.out.println("Invalid choice, please try again: ");
            }
        }

        k.close();

    }
}
