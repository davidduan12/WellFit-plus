package use_case.user_login;

public class LoginInputData {

    private String username;
    private String password;
    private int age;
    private double weight; // in kilograms
    private double height; // in meters

    private String sex;

    private double bmi;

    public LoginInputData(String username, String password, int age, double weight, double height, String sex, double bmi){
        this.username = username;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.bmi = bmi;
    }

    public String getUsername() {
        return this.username;
    }
}
