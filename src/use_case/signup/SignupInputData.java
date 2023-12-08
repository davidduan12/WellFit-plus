package use_case.signup;

/**
 * Class representing the input data required for the signup process.
 * contains username, password, and weight and height.
 */
public class SignupInputData {
    final private String username;
    final private String password;
    final private String repeatPassword;

    final private double weight;

    private double height;


    /**
     * Constructor for SignupInputData.
     *
     * @param username       The desired username for the new account.
     * @param password       The password for the new account.
     * @param repeatPassword The repeated password for verification.
     * @param weight         The weight of the user.
     * @param height         The height of the user.
     */
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
