package app;

import data_access.FileUserDataAccessObject;
import data_access.FoodDataAccessObject;
import interface_adapter.AddExercise.AddExerciseViewModel;
import interface_adapter.AddFood.AddFoodViewModel;
import view.FoodView;
import view.MainFrame;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        AddFoodViewModel addFoodViewModel = new AddFoodViewModel();
        AddExerciseViewModel addExerciseViewModel = new AddExerciseViewModel();

        FileUserDataAccessObject userDataAccessObject = null; // = null for now
       /* try{
            userDataAccessObject = new FileUserDataAccessObject("./data/sample_user.csv");
            // userDataAccessObject = new FileUserDataAccessObject("./data/sample_user.csv", new )          fix fileuserdataacccessobject
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        FoodDataAccessObject foodDataAccessObject = new FoodDataAccessObject("./data/sample_user.csv");
        String query = "ran 3 miles";
        String responseData = foodDataAccessObject.fetchDataFromNutritionix(query);
        System.out.println(responseData);

        /*try{
            foodDataAccessObject = new FoodDataAccessObject("./data/sample_user.csv");
        } catch (IOException e) {           //fix both
            throw new RuntimeException(e);
        }*/


        FileUserDataAccessObject finalUserDataAccessObject = userDataAccessObject;
        FoodDataAccessObject finalFoodDataAccessObject = foodDataAccessObject;
        SwingUtilities.invokeLater(() -> {
            //Main window
            JFrame application = new MainFrame(addFoodViewModel, finalUserDataAccessObject, finalFoodDataAccessObject);
            application.setVisible(true);
        });



    }


}
