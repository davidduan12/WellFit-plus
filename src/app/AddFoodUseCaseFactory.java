package app;

import interface_adapter.AddFood.AddFoodController;
import interface_adapter.AddFood.AddFoodPresenter;
import interface_adapter.AddFood.AddFoodViewModel;
import use_case.UserDataAccessInterface;
import use_case.add_food.FoodAddDataAccessInterface;
import use_case.add_food.AddFoodInputBoundary;
import use_case.add_food.AddFoodInteractor;
import use_case.add_food.AddFoodOutputBoundary;
import use_case.UserDataAccessInterface;
import view.FoodView;

import javax.swing.*;
import java.io.IOException;

public class AddFoodUseCaseFactory {
    private AddFoodUseCaseFactory() {}

    public static FoodView create(
            AddFoodViewModel addFoodViewModel,
            FoodAddDataAccessInterface foodDataAccessObject,
            UserDataAccessInterface fileUserDataAccessObject) {
        try {
            AddFoodController addFoodController = createAddFoodUser(addFoodViewModel, fileUserDataAccessObject, foodDataAccessObject);
            return new FoodView(addFoodViewModel, addFoodController);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Could not open user data file");
        }

        return null;
    }

    private static AddFoodController createAddFoodUser(
            AddFoodViewModel addFoodViewModel,
            UserDataAccessInterface fileUserDataAccessObject,
            FoodAddDataAccessInterface foodDataAccessObject
    ) throws IOException {
        AddFoodOutputBoundary addFoodOutputBoundary = new AddFoodPresenter(addFoodViewModel);
        AddFoodInputBoundary addFoodInteractor = new AddFoodInteractor(foodDataAccessObject, addFoodOutputBoundary, fileUserDataAccessObject);
        return new AddFoodController(addFoodInteractor);

    }

}
