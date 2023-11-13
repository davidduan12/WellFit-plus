package use_case.add_food;

import data_access.FileUserDataAccessObject;
import interface_adapter.AddFood.AddFoodController;
import interface_adapter.AddFood.AddFoodPresenter;
import use_case.FoodAddDataAccessInterface;

import javax.swing.*;

public class AddFoodInteractor implements AddFoodInputBoundary{

    private final FoodAddDataAccessInterface foodAddDataAccessInterface;
    private final FileUserDataAccessObject fileUserDataAccessObject;

    final AddFoodPresenter addFoodPresenter;

    final AddFoodController addFoodController;

    public AddFoodInteractor(FoodAddDataAccessInterface foodAddDataAccessInterface, FileUserDataAccessObject fileUserDataAccessObject, AddFoodOutputBoundary addFoodPresenter, AddFoodController addFoodController) {
        this.foodAddDataAccessInterface = foodAddDataAccessInterface;
        this.fileUserDataAccessObject = fileUserDataAccessObject;
        this.addFoodPresenter = (AddFoodPresenter) addFoodPresenter;
        this.addFoodController = addFoodController;
    }

    @Override
    public void execute(InputData inputData) {
        //first get data from reading the csv
        fileUserDataAccessObject.readToCSV("/data/sample_user.csv");


        fileUserDataAccessObject.writeToCSV("/data/sample_user.csv",);

//        f = new JFrame();
//        JOptionPane.showMessageDialog(f, "Success");
        OutputData foodOutputData = new OutputData();
        addFoodPresenter.prepareSuccessView(foodOutputData);
    }
}
