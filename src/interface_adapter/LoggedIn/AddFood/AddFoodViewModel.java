package interface_adapter.LoggedIn.AddFood;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

// No View Model Avaliable
public class  AddFoodViewModel extends ViewModel {// ViewModel still works. Plz import it after finishing

    public static final String TITLE_LABEL = "Food Panel";
    public static final String ADD_BUTTON_LABEL = "Add";
    public static final String FOOD_LABEL = "Choose food";
    public static final String WEIGHT_LABEL = "Enter weight (g)";

    private AddFoodState state = new AddFoodState();

    public AddFoodViewModel(){super("add food");}

    public void setState(AddFoodState state){
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public AddFoodState getState(){
        return state;
    }

}
