package entity;

public class Exercise {

    private String name;

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    private float duration;
    private float caloriesBurnedPerHour;

    public Exercise(String name, float caloriesBurnedPerHour) {
        this.name = name;
        this.caloriesBurnedPerHour = caloriesBurnedPerHour;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public float getCaloriesBurnedPerHour() {
        return caloriesBurnedPerHour;
    }

}
