package app;

import data_access.FileUserDataAccessObject;
import data_access.FoodDataAccessObject;
import interface_adapter.AddExercise.AddExerciseViewModel;
import interface_adapter.AddFood.AddFoodViewModel;
import interface_adapter.SignUp.SignupViewModel;
import interface_adapter.UserLogin.LoginViewModel;
import interface_adapter.ViewManagerModel;
import view.MainPanel;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {


        AddFoodViewModel addFoodViewModel = new AddFoodViewModel();
        AddExerciseViewModel addExerciseViewModel = new AddExerciseViewModel();

        FileUserDataAccessObject userDataAccessObject = null; // = null for now



       /* try{
            userDataAccessObject = new FileUserDataAccessObject("./data/sample_user.csv");
            // userDataAccessObject = new FileUserDataAccessObject("./data/sample_user.csv", new ) fix fileuserdataacccessobject
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        FoodDataAccessObject foodDataAccessObject = new FoodDataAccessObject("./data/sample_user.csv");
//        String query = "ran 3 miles";
//        Double responseData = foodDataAccessObject.apiExercise(query);
//        System.out.println(responseData);
//
//        query = "3 eggs";
//        responseData = foodDataAccessObject.apiNutrient(query);
//        System.out.println(responseData);

        /*try{
            foodDataAccessObject = new FoodDataAccessObject("./data/sample_user.csv");
        } catch (IOException e) {           //fix both
            throw new RuntimeException(e);
        }*/


        FileUserDataAccessObject finalUserDataAccessObject = userDataAccessObject;
        FoodDataAccessObject finalFoodDataAccessObject = foodDataAccessObject;
        SwingUtilities.invokeLater(() -> {
            //Main window
            JFrame application = new JFrame("Javakiller");
            application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            CardLayout cardLayout = new CardLayout();

            //Various View objects.
            JPanel views = new JPanel(cardLayout);
            application.add(views);

            //Keeps track of active view
            ViewManagerModel viewManagerModel = new ViewManagerModel();
            new ViewManager(views, cardLayout, viewManagerModel);

            //Data for views
            SignupViewModel signupViewModel = new SignupViewModel();
            LoginViewModel loginViewModel = new LoginViewModel();
            JPanel mainPanel = new MainPanel(addFoodViewModel, finalUserDataAccessObject, finalFoodDataAccessObject);

            FileUserDataAccessObject userDataAccessObject;

            try {
                userDataAccessObject = new FileUserDataAccessObject("./", new Common)
            }
            application.pack();
            application.setVisible(true);
        });



    }


}
