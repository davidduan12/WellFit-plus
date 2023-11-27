package use_case.user_login;

public interface LoginInputBondary {
    void login(String username, String password, int age, double weight, double height, String sex, double bmi);

    void login(String username, String password);
}
