package use_case.add_food;

import data_access.FileUserDataAccessObject;
import data_access.FoodDataAccessObject;
import data_access.NutritionixAPICaller;
import use_case.UserDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;

public class AddFoodInteractor implements AddFoodInputBoundary{

    final FoodAddDataAccessInterface foodDataAccessObject;

    final UserDataAccessInterface fileUserDataAccessObject;
    final AddFoodOutputBoundary addFoodOutputBoundary;


    public AddFoodInteractor(FoodAddDataAccessInterface foodDataAccessObject, AddFoodOutputBoundary addFoodOutputBoundary, UserDataAccessInterface fileUserDataAccessObject) {
        this.foodDataAccessObject = foodDataAccessObject;
        this.addFoodOutputBoundary = addFoodOutputBoundary;
        this.fileUserDataAccessObject = fileUserDataAccessObject;
    }

    //read from FoodDataAccessObject which calls api and return something, and write the fileuserdataaccessobject which store user info
    @Override
    public void execute(AddFoodInputData inputData) {
        String query = inputData.getWeight() + " of " + inputData.getName();
        double calorieData = foodDataAccessObject.apiNutrient(query);
        //first get data from reading the csv
        if (calorieData == -1){
            addFoodOutputBoundary.prepareFailView();
        }else{
//            to be added
//            ArrayList<ArrayList<String>> records = fileUserDataAccessObject.readToCSV("/data/sample_user.csv");
//            fileUserDataAccessObject.writeToCSV(records);
            AddFoodOutputData out = new AddFoodOutputData(inputData.getName());
            addFoodOutputBoundary.prepareSuccessView(out);
        }


    }
}


// if (foodDataAccessObject.existByName(food)){
//         addFoodPresenter.prepareFailView("Food Already Exist");
//         }
//         else {
//         ArrayList<String> foodSpecifications = new ArrayList<>();
//        foodSpecifications.add(food);
//        //then write to csv
//        fileUserDataAccessObject.writeToCSV("/data/sample_user.csv",foodSpecifications);
//
////        f = new JFrame();
////        JOptionPane.showMessageDialog(f, "Success");
//        addFoodPresenter.prepareSuccessView(foodOutputData);
//
//        }