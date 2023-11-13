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

    public User(String username, String password, int age, double weight, double height, String sex, String name) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.name = name;
        this.bmi = bmi;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBMI() {return bmi;}

    public void setBMI(Double bmi) { this.bmi = bmi; }

}
