package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    private Food food;

    @BeforeEach
    void setUp() {
        food = new Food("Apple", 52);
    }

    @AfterEach
    void tearDown() {
        food = null;
    }

    @Test
    void getServing() {
        food.setServing(2);
        assertEquals(2, food.getServing());
    }


    @Test
    void setServing() {
        food.setServing(5);
        assertEquals(5, food.getServing());
    }

    @Test
    void getName() {
        assertEquals("Apple", food.getName());
    }

    @Test
    void getCalories() {
        assertEquals(52, food.getCalories());
    }
}