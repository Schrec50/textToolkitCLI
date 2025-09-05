package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

public class TaskTest {

    //Reset each task ID before any test runs
    @BeforeEach
    void resetIds(){
        Task.resetCounter();
    }

    @Test
    void testMarkCompleted(){
        //Arrange
        Task task = new Task("Dig a hole.");

        //Act
        task.markComplete(); //Call the method you want tested

        //Assert
        //This assert makes sure a boolean returns true.
        assertTrue(task.isCompleted());
    }

    @Test
    void testGetDescription(){
        //Arange 
        Task task1 = new Task("Make a task");

        //Assert
        
        //This assert compares two things and check if they're equal
        assertEquals("Make a task", task1.getDescription());
    }

    @Test
    void testToString(){
        //Arange 
        Task task2 = new Task("Test the toString() method.");

        //Act
        task2.markComplete();
        
        //Assert
        assertEquals("Task 0: Test the toString() method. | Status: Completed",
             task2.toString());


    }
    
    }

