package app;

import data_access.FileUserDataAccessObject;
import interface_adapter.LoggedIn.AddFood.AddFoodController;
import interface_adapter.LoggedIn.AddFood.AddFoodPresenter;
import interface_adapter.LoggedIn.AddFood.AddFoodViewModel;
import use_case.UserDataAccessInterface;
import use_case.LoggedIn.add_food.FoodAddDataAccessInterface;
import use_case.LoggedIn.add_food.AddFoodInputBoundary;
import use_case.LoggedIn.add_food.AddFoodInteractor;
import use_case.LoggedIn.add_food.AddFoodOutputBoundary;
import view.FoodView;

import javax.swing.*;
import java.io.IOException;

public class AddFoodUseCaseFactory {
    private AddFoodUseCaseFactory() {}

    public static FoodView create(
            AddFoodViewModel addFoodViewModel,
            FoodAddDataAccessInterface foodDataAccessObject) {
        try {
            AddFoodController addFoodController = createAddFoodUser(addFoodViewModel, foodDataAccessObject);
            return new FoodView(addFoodViewModel, addFoodController);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Could not open user data file");
        }

        return null;
    }

    private static AddFoodController createAddFoodUser(
            AddFoodViewModel addFoodViewModel,
            FoodAddDataAccessInterface fileUserDataAccessObject
    ) throws IOException {
        AddFoodOutputBoundary addFoodOutputBoundary = new AddFoodPresenter(addFoodViewModel);
        AddFoodInputBoundary addFoodInteractor = new AddFoodInteractor(addFoodOutputBoundary, fileUserDataAccessObject);
        return new AddFoodController(addFoodInteractor);

    }

}
