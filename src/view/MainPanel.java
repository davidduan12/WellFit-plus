package view;

import javax.swing.*;
import java.awt.*;

import app.AddExerciseUseCaseFactory;
import app.AddFoodUseCaseFactory;
import data_access.FileUserDataAccessObject;
import interface_adapter.LoggedIn.AddExercise.AddExerciseViewModel;
import interface_adapter.LoggedIn.AddFood.AddFoodViewModel;
import interface_adapter.LoggedIn.LoggedInViewModel;
import use_case.UserDataAccessInterface;
import use_case.LoggedIn.add_food.FoodAddDataAccessInterface;

public class MainPanel extends JPanel {
    private JTabbedPane tabbedPane;
    public final String viewName = "logged in";

    private void MainPanel(AddFoodViewModel addFoodViewModel, AddExerciseViewModel addExerciseViewModel, FileUserDataAccessObject userDataAccessObject) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        setTitle("Health Tracker Application");
//        setSize(600, 800);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
        tabbedPane = new JTabbedPane();

        // Put the tabs at the bottom
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);

        FoodView foodView = AddFoodUseCaseFactory.create(addFoodViewModel, userDataAccessObject);
        ExerciseView exerciseView = AddExerciseUseCaseFactory.create(addExerciseViewModel, userDataAccessObject);
       // ProfileView profileView = AddProfileUseCaseFactory.create(addProfile); TODO: after finished addprofile view and usecasefactory
        // Add panels to the tabbed pane
        tabbedPane.addTab("Food", foodView);
        tabbedPane.addTab("Exercise", exerciseView);
        tabbedPane.addTab("Profile", createProfilePanel());
        // Custom tab component to increase tab size
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowOpened(WindowEvent e) {
//
//                setCustomTabs(getContentPane().getWidth()/3,30);
//            }
//        });
//        getContentPane().add(tabbedPane, BorderLayout.CENTER);
     }
    private void setCustomTabs(int width, int height) {

        for (int i = 0; i < 3; i++) {
            JLabel label = new JLabel(tabbedPane.getTitleAt(i), SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(width, height));
            tabbedPane.setTabComponentAt(i, label);
        }
    }


    private JPanel createExercisePanel() {
        // Your Exercise panel code
        return (new JPanel());
    }

    private JPanel createProfilePanel() {
        // Your Profile panel code
        return (new JPanel());
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }*/
}