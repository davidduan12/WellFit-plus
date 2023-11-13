package use_case.add_food;

import data_access.FileUserDataAccessObject;
import data_access.FoodDataAccessObject;
import use_case.FoodAddDataAccessInterface;

import javax.swing.*;

public class AddFoodInteractor implements AddFoodInputBoundary{

    private final FoodAddDataAccessInterface foodAddDataAccessInterface;
    private final FileUserDataAccessObject fileUserDataAccessObject;

    final AddFoodOutputBoundary addFoodPresenter;

    public AddFoodInteractor(FoodAddDataAccessInterface foodAddDataAccessInterface, FileUserDataAccessObject fileUserDataAccessObject, AddFoodOutputBoundary addFoodPresenter) {
        this.foodAddDataAccessInterface = foodAddDataAccessInterface;
        this.fileUserDataAccessObject = fileUserDataAccessObject;
        this.addFoodPresenter = addFoodPresenter;
    }

    @Override
    public void execute(InputData inputData) {
        fileUserDataAccessObject.writeToCSV("\data\sample_user.csv");

        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Success");
    }
}
