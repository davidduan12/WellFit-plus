package interface_adapter.LoggedIn.EditProfile;

import interface_adapter.LoggedIn.AddFood.AddFoodState;
import interface_adapter.ViewModel;

import javax.swing.text.View;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditProfileViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Profile Panel";
    public static final String SUBMIT_BUTTON_LABEL = "Submit";
    public static final String USERNAME_LABEL = "Username";
    public static final String PASSWORD_LABEL = "Password";
    public static final String WEIGHT_LABEL = "Weight";
    public static final String HEIGHT_LABEL = "Height";
    private EditProfileState state = new EditProfileState();


    public EditProfileViewModel(){super("edit user");}

    public void setState(EditProfileState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);




    @Override
    public void firePropertyChanged() {
            support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public EditProfileState getState(){
        return state;
    }

}
