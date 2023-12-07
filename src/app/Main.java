package app;

import data_access.FileUserDataAccessObject;
import entity.UserFactory;
import interface_adapter.LoggedIn.AddExercise.AddExerciseViewModel;
import interface_adapter.LoggedIn.AddFood.AddFoodViewModel;
import interface_adapter.LoggedIn.EditProfile.EditProfileViewModel;
import interface_adapter.LoggedIn.LoggedInViewModel;
import interface_adapter.SignUp.SignupViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

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
            LoggedInViewModel loggedInViewModelloggedInViewModel = new LoggedInViewModel();
            AddFoodViewModel addFoodViewModel = new AddFoodViewModel();
            AddExerciseViewModel addExerciseViewModel = new AddExerciseViewModel();
            EditProfileViewModel editProfileViewModel = new EditProfileViewModel();

            FileUserDataAccessObject userDataAccessObject;

            try {
                userDataAccessObject = new FileUserDataAccessObject("./data/user.csv", new UserFactory());
            } catch (IOException e){
                throw new RuntimeException(e);
            }

            SignUpView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
            views.add(signupView, signupView.viewName);

            LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
            views.add(loginView, loginView.viewName);

            FoodView foodView = AddFoodUseCaseFactory.create(addFoodViewModel,loggedInViewModel, userDataAccessObject);

            ExerciseView exerciseView = AddExerciseUseCaseFactory.create(addExerciseViewModel, loggedInViewModel, userDataAccessObject);

            ProfileView profileView = EditProfileUseCaseFactory.create(editProfileViewModel, loggedInViewModel, userDataAccessObject);

            MainPanel mainPanel = new MainPanel(loggedInViewModel, viewManagerModel, foodView, exerciseView, profileView);

            views.add(mainPanel, mainPanel.viewName);
            application.pack();
            application.setVisible(true);




    }


}
