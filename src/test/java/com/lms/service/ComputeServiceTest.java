package com.lms.service;

import com.lms.model.Learner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ComputeServiceTest {
    ComputeService computeService;

    @BeforeEach
    public void init(){
        computeService = new ComputeService();
    }

    @Test
    public void computePercentageTest(){

        //checking valid values
        double total_marks = 500;
        double scored = 450;
        double exprected = 90;
        double actual = computeService.computePercentage(total_marks, scored);

        assertEquals(exprected, actual, 0.001);

        //checking whether correct exception is thrown or not
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,  ()->{
            computeService.computePercentage(total_marks, 535);
        });
        assertEquals("Marks cannot be greater than total marks", e.getMessage());

        assertDoesNotThrow(()->{
            computeService.computePercentage(total_marks, 450);
        });

       e = assertThrows(IllegalArgumentException.class,  ()->{
            computeService.computePercentage(total_marks, -535);
        });
        assertEquals("Marks cannot be negative", e.getMessage());
    }

    @Test
    public void computeGradeTest(){
        double percentage = 90;
        char exprected = 'A';
        char actual = computeService.computeGrade(percentage);
        assertEquals(exprected, actual);

        double percentage1 = 40;
        char exprected1 = 'F';
        char actual1 = computeService.computeGrade(percentage1);
        assertEquals(exprected1, actual1);
    }


    @Test
    public void filterListByIdTest(){

        RuntimeException e = assertThrows(RuntimeException.class,  ()->{
            computeService.filterListById(null, 1);
        });
        assertEquals("List cannot be null", e.getMessage());
        e = assertThrows(RuntimeException.class,  ()->{
            computeService.filterListById(List.of(), 1);
        });
        assertEquals("List cannot be empty", e.getMessage());


        Learner learner1 = new Learner(1, "Ashok", "<EMAIL>");
        Learner learner2 = new Learner(2, "Raj", "<EMAIL>");

        List<Learner> learners = List.of(learner1, learner2);
        List<Learner> expected = List.of(learner2);
        List<Learner> actual = computeService.filterListById(learners, 1);
        assertEquals(expected, actual);
    }






}