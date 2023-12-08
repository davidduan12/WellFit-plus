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

    private double totalCaloriesIntake = 0;

    private double totalCaloriesExpenditure = 0;

    public User(String username, String password, double height, double weight) {
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


    public double getTotalCaloriesIntake() {
        return totalCaloriesIntake;
    }

    public void setTotalCaloriesIntake(double totalCaloriesIntake) {
        this.totalCaloriesIntake = totalCaloriesIntake;
    }

    public double getTotalCaloriesExpenditure() {
        return totalCaloriesExpenditure;
    }

    public void setTotalCaloriesExpenditure(double totalCaloriesExpenditure) {
        this.totalCaloriesExpenditure = totalCaloriesExpenditure;
    }

    public void setBmi(){
        double BMI = weight/((height/100 * height/100));
        this.bmi = BMI;
        System.out.println(bmi);
    }
    public double getBmi(){
        return bmi;
    }
}
