package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import app.AddFoodUseCaseFactory;
import data_access.FoodDataAccessObject;
import interface_adapter.AddFood.AddFoodViewModel;
import use_case.UserDataAccessInterface;
import use_case.add_food.FoodAddDataAccessInterface;
import view.FoodView;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;

    public MainFrame(AddFoodViewModel addFoodViewModel, UserDataAccessInterface userDataAccessObject, FoodAddDataAccessInterface foodDataAccessObject){
        initUI(addFoodViewModel, userDataAccessObject, foodDataAccessObject);
    }

    private void initUI(AddFoodViewModel addFoodViewModel, UserDataAccessInterface userDataAccessObject, FoodAddDataAccessInterface foodDataAccessObject) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Health Tracker Application");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        tabbedPane = new JTabbedPane();

        // Put the tabs at the bottom
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);

        FoodView foodView = AddFoodUseCaseFactory.create(addFoodViewModel, foodDataAccessObject, userDataAccessObject);
        // Add panels to the tabbed pane
        tabbedPane.addTab("Food", foodView);
        tabbedPane.addTab("Exercise", createExercisePanel());
        tabbedPane.addTab("Profile", createProfilePanel());

        // Custom tab component to increase tab size
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {

                setCustomTabs(getContentPane().getWidth()/3,30);
            }
        });
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
    private void setCustomTabs(int width, int height) {

        for (int i = 0; i < 3; i++) {
            JLabel label = new JLabel(tabbedPane.getTitleAt(i), SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(width, height));
            tabbedPane.setTabComponentAt(i, label);
        }
    }




    private JPanel createFoodPanel() {

        return
    }

    private JPanel createExercisePanel() {
        // Your Exercise panel code
        return (new JPanel());
    }

    private JPanel createProfilePanel() {
        // Your Profile panel code
        return (new JPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}