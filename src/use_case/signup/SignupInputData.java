package use_case.signup;

public class SignupInputData {
    final private String username;
    final private String password;
    final private String repeatPassword;

    final private double weight;

    private double height;



    public SignupInputData(String username, String password, String repeatPassword, double weight, double height) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.weight = weight;
        this.height = height;
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

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }


}
