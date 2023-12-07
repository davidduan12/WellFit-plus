package use_case.LoggedIn.edit_profile;

public class EditProfileOutputdata {

    private final String username;

    private final String password;

    private final double height;

    private final double weight;

    private boolean useCaseFailed;




    public EditProfileOutputdata(String username, String password, double height, double weight, boolean useCaseFailed) {
        this.username = username;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public void setUseCaseFailed(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
}
