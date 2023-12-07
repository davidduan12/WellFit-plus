package use_case.LoggedIn.add_food;

import interface_adapter.LoggedIn.LoggedInState;
import interface_adapter.LoggedIn.LoggedInViewModel;
import use_case.UserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class AddFoodInteractor implements AddFoodInputBoundary{


    final FoodAddDataAccessInterface fileUserDataAccessObject;
    final AddFoodOutputBoundary addFoodOutputBoundary;

    final LoggedInViewModel loggedInViewModel;

    public AddFoodInteractor(AddFoodOutputBoundary addFoodOutputBoundary, FoodAddDataAccessInterface fileUserDataAccessObject, LoggedInViewModel loggedInViewModel) {
        this.addFoodOutputBoundary = addFoodOutputBoundary;
        this.fileUserDataAccessObject = fileUserDataAccessObject;
        this.loggedInViewModel = loggedInViewModel;
    }

    //read from FoodDataAccessObject which calls api and return something, and write the fileuserdataaccessobject which store user info
    @Override
    public void execute(AddFoodInputData inputData) {
        String query = inputData.getWeight() + "gram of " + inputData.getName();
        double calorieData = fileUserDataAccessObject.apiNutrient(query);
        //first get data from reading the csv
        if (calorieData == -1){
            addFoodOutputBoundary.prepareFailView("Invalid Input");
        }else{
            Map<String, Double> data = new HashMap<>();
            data.put(inputData.getName(), calorieData);
            fileUserDataAccessObject.writeFoodCaloriesToCSV(data, loggedInViewModel.getLoggedInUser());
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