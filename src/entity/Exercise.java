package entity;

public class Exercise {

    private String name;
    private int caloriesBurnedPerHour;

    public Exercise(String name, int caloriesBurnedPerHour) {
        this.name = name;
        this.caloriesBurnedPerHour = caloriesBurnedPerHour;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getCaloriesBurnedPerHour() {
        return caloriesBurnedPerHour;
    }

}
