package entity;

public class User {
    private String username;

    private String name;
    private String password;
    private int age;
    private double weight; // in kilograms
    private double height; // in meters

    private String sex;

    private double bmi;

    private float totalCaloriesIntake = 0;

    private float totalCaloriesExpenditure = 0;

    public User(String username, String password, double weight, double height) {
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.height = height;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public float getTotalCaloriesIntake() {
        return totalCaloriesIntake;
    }

    public void setTotalCaloriesIntake(float totalCaloriesIntake) {
        this.totalCaloriesIntake = totalCaloriesIntake;
    }

    public float getTotalCaloriesExpenditure() {
        return totalCaloriesExpenditure;
    }

    public void setTotalCaloriesExpenditure(float totalCaloriesExpenditure) {
        this.totalCaloriesExpenditure = totalCaloriesExpenditure;
    }
}
