package use_case.add_food;

import data_access.FileUserDataAccessObject;
import interface_adapter.AddFood.AddFoodController;
import interface_adapter.AddFood.AddFoodPresenter;
import use_case.FoodAddDataAccessInterface;
import data_access.FoodDataAccessObject;

import java.util.ArrayList;

public class AddFoodInteractor implements AddFoodInputBoundary{

    private final FoodAddDataAccessInterface foodAddDataAccessInterface;
    private final FileUserDataAccessObject fileUserDataAccessObject;
    private final FoodDataAccessObject foodDataAccessObject;

    final AddFoodPresenter addFoodPresenter;

    final AddFoodController addFoodController;

    public AddFoodInteractor(FoodAddDataAccessInterface foodAddDataAccessInterface, FileUserDataAccessObject fileUserDataAccessObject, FoodDataAccessObject foodDataAccessObject, AddFoodOutputBoundary addFoodPresenter, AddFoodController addFoodController) {
        this.foodAddDataAccessInterface = foodAddDataAccessInterface;
        this.fileUserDataAccessObject = fileUserDataAccessObject;
        this.foodDataAccessObject = foodDataAccessObject;
        this.addFoodPresenter = (AddFoodPresenter) addFoodPresenter;
        this.addFoodController = addFoodController;
    }

    @Override
    public void execute(InputData inputData) {
        //first get data from reading the csv
        fileUserDataAccessObject.readToCSV("/data/sample_user.csv");

        String foodName = inputData.getFoodName();
        String foodCalorie = inputData.getFoodCalories();

        OutputData foodOutputData = new OutputData();
        //use food access object to add food
        //first check if they exist
        if (foodDataAccessObject.existByName(foodName)){
            addFoodPresenter.prepareFailView("Food Already Exist");
        }
        else {
            ArrayList<String> foodSpecifications = new ArrayList<>();
            foodSpecifications.add(foodName);
            foodSpecifications.add(foodCalorie);
            //then write to csv
            fileUserDataAccessObject.writeToCSV("/data/sample_user.csv",foodSpecifications);

//        f = new JFrame();
//        JOptionPane.showMessageDialog(f, "Success");
            addFoodPresenter.prepareSuccessView(foodOutputData);

        }



    }
}
