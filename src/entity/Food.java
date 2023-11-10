package entity;

public class Food {

    private String name;
    private int calories;
    /** Returns the calorie for the food. */
    public Food(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

}
