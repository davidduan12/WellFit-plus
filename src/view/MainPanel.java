package view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import app.AddExerciseUseCaseFactory;
import app.AddFoodUseCaseFactory;
import data_access.FileUserDataAccessObject;
import entity.Food;
import interface_adapter.LoggedIn.AddExercise.AddExerciseViewModel;
import interface_adapter.LoggedIn.AddFood.AddFoodViewModel;
import interface_adapter.LoggedIn.LoggedInViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import use_case.UserDataAccessInterface;
import use_case.LoggedIn.add_food.FoodAddDataAccessInterface;

public class MainPanel extends JPanel implements ActionListener, PropertyChangeListener {
    private JTabbedPane tabbedPane;
    private LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;
    public final String viewName = "logged in";

    public MainPanel(LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel, FoodView foodView, ExerciseView exerciseView, ProfileView profileView) {
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel.addPropertyChangeListener(this);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        tabbedPane = new JTabbedPane();

        // Put the tabs at the bottom
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);

        // Add panels to the tabbed pane
        tabbedPane.addTab("Food", foodView);
        tabbedPane.addTab("Exercise", exerciseView);
        tabbedPane.addTab("Profile", profileView);
        setSize(600, 800);

        setVisible(true);
        // Custom tab component to increase tab size
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowOpened(WindowEvent e) {
//
//                setCustomTabs(getContentPane().getWidth()/3,30);
//            }
//        });
//        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        this.add(tabbedPane);

        // Add the ChangeListener
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
                // Add any additional actions you want to perform on tab change here
                if (index == 2){
                    profileView.displayUserInfo(loggedInViewModel.getLoggedInUser());
                }
            }
        });
     }
    private void setCustomTabs(int width, int height) {

        for (int i = 0; i < 3; i++) {
            JLabel label = new JLabel(tabbedPane.getTitleAt(i), SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(width, height));
            tabbedPane.setTabComponentAt(i, label);
        }
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }


}