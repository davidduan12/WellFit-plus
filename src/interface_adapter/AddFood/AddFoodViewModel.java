package interface_adapter.AddFood;


import java.beans.PropertyChangeSupport;

// No View Model Avaliable
public class AddFoodViewModel extends ViewModel {// ViewModel still works. Plz import it after finishing
    private AddFoodState state = new AddFoodState();

    public AddFoodViewModel(){super();//viewname
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }

    public AddFoodState getState(){
        return state;
    }

    public void setAddState(AddFoodState foodState){
        this.state = foodState;
    }
}
