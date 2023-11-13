package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;

    public MainFrame() {
        initUI();
    }

    private void initUI() {
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

        // Add your panels to the tabbed pane
        tabbedPane.addTab("Food", createFoodPanel());
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
        // Your Food panel code
        JPanel foodPanel = new JPanel();
        JComboBox<String> foodComboBox = new JComboBox<>(new String[]{"Apple", "Orange", "Banana"});
        JButton addButton = new JButton("Add");

        // Load food items from CSV into the combo box

        // Add components to the panel
        foodPanel.add(foodComboBox, BorderLayout.CENTER);
        foodPanel.add(addButton, BorderLayout.EAST);

        // Event listener for the Add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFood = (String) foodComboBox.getSelectedItem();
                // Handle the addition of selected food
                System.out.println("Food added: " + selectedFood);
                // Further implementation...
            }
        });

        return foodPanel;
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