package com.example;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class taskManagerTest {
    
    @BeforeEach
    void resetIds(){
        Task.resetCounter();
    }

    //Test for addTask
    @Test
    void testAddTask(){
        //Arrange
        taskManager manager = new taskManager();
        
        //Act
        manager.addTask("Sweep the floor");

        //Assert
        assertEquals(1, manager.getSize());
    }

    @Test
    void testListTasks(){
        //Arrange 
        taskManager manager = new taskManager();
        manager.addTask("Sweep the floor.");
        manager.addTask("Do the dishes.");
        manager.addTask("Do the Laundry");

        //Act
        List<Task> tasks = manager.listTasks();

        //Assert
        assertEquals(3, tasks.size());
        assertEquals("Do the dishes.", tasks.get(1).getDescription());
    }

    @Test
     public void testCompleteTask(){
        //Arrange
        taskManager manager = new taskManager();
        manager.addTask("Do the dishes.");
        manager.addTask("Sweep the floor.");

        //Act
        manager.completeTask(2);

        //Assert
        assertTrue(manager.getTaskById(2).isCompleted());
     }

     @Test 
     public void testRemoveTask(){
        //Arrange
        taskManager manager = new taskManager();
        manager.addTask("Do the dishes.");
        manager.addTask("Sweep the floor");
        boolean wasRemoved = true;

        //Act
        manager.removeTask(2);

        //Assert;
        for(Task task : manager.listTasks()){
            if(task.getId() == 2){
                wasRemoved = false;
            }
        }
        assertTrue(wasRemoved);
    }

}
