package use_case.LoggedIn.edit_profile;

/**
 * Data class representing input data for editing a user profile.
 */
public class EditProfileInputData {

    final private String name;
    final private double weight;
    final private double height;
    final private String password;

    public EditProfileInputData(String name, String password, double weight, double height){
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getPassword() {
        return password;
    }
}