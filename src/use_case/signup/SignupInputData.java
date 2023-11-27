package use_case.signup;

public class SignupInputData {
    final private String username;
    final private String password;
    final private String repeatPassword;

    final private int age;

    final private double weight;

    private double height;

    private String sex;

    private String name;


    public SignupInputData(String username, String password, String repeatPassword, int age, double weight, double height, String sex, String name) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.name = name;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }


}
