package interface_adapter.LoggedIn;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoggedInViewModel extends ViewModel {
    public final String TITLE_LABEL = "Logged In View";

    private LoggedInState state = new LoggedInState();

    private String loggedInUser;

    public LoggedInViewModel(){
        super("logged in");
    }

    public void setState(LoggedInState state){
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LoggedInState getState() {
        return state;
    }

    public String getLoggedInUser(){
        return loggedInUser;
    }
    public void setLoggedInUser(String loggedInUser){
        this.loggedInUser = loggedInUser;
    }

}
