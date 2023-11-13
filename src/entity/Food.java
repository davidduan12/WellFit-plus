package entity;

public class Food {

    private String name;
    private float calories;

    public float getServing() {
        return serving;
    }

    public void setServing(float serving) {
        this.serving = serving;
    }

    private float serving;
    /** Returns the calorie for the food. */
    public Food(String name, float calories) {
        this.name = name;
        this.calories = calories;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public float getCalories() {
        return calories;
    }

}
