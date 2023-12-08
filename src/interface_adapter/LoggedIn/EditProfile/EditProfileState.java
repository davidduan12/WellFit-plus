package interface_adapter.LoggedIn.EditProfile;


public class EditProfileState {
    private String Username = "";

    private String password = "";
    private double weight = 0;
    private double height= 0;

    private String editProfileError = "";

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
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


    public String getEditProfileError() {
        return editProfileError;
    }

    public void setEditProfileError(String editProfileError) {
        this.editProfileError = editProfileError;
    }
}
