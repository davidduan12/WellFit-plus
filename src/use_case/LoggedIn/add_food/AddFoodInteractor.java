package use_case.LoggedIn.add_food;

import use_case.UserDataAccessInterface;

public class AddFoodInteractor implements AddFoodInputBoundary{


    final FoodAddDataAccessInterface fileUserDataAccessObject;
    final AddFoodOutputBoundary addFoodOutputBoundary;


    public AddFoodInteractor(AddFoodOutputBoundary addFoodOutputBoundary, FoodAddDataAccessInterface fileUserDataAccessObject) {
        this.addFoodOutputBoundary = addFoodOutputBoundary;
        this.fileUserDataAccessObject = fileUserDataAccessObject;
    }

    //read from FoodDataAccessObject which calls api and return something, and write the fileuserdataaccessobject which store user info
    @Override
    public void execute(AddFoodInputData inputData) {
        String query = inputData.getWeight() + "gram of " + inputData.getName();
        double calorieData = fileUserDataAccessObject.apiNutrient(query);
        //first get data from reading the csv
        if (calorieData == -1){
            addFoodOutputBoundary.prepareFailView("error"); //TODO: error check some how
        }else{
//            to be added
//            ArrayList<ArrayList<String>> records = fileUserDataAccessObject.readToCSV("/data/sample_user.csv");
//            fileUserDataAccessObject.writeToCSV(records);
            AddFoodOutputData out = new AddFoodOutputData(inputData.getName());
            System.out.println(calorieData);
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