package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileView extends JPanel {
    private JButton editProfileButton;
    private JTextArea userInfoArea;

    public ProfileView() {
        this.setLayout(new BorderLayout());

        userInfoArea = new JTextArea(10, 30);
        userInfoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(userInfoArea);
        this.add(scrollPane, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        editProfileButton = new JButton("Edit Profile");
        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEditDialog();
            }
        });
        buttonPanel.add(editProfileButton);
        this.add(buttonPanel, BorderLayout.CENTER);

        displayUserInfo();
    }

    private void displayUserInfo() {
        String userInfo = "Username: user123\n"
                + "Height: 175 cm\n"
                + "Weight: 70 kg\n"
                + "Password: password123\n"
                + "History: [Some user history]";
        userInfoArea.setText(userInfo);
    }


    private void showEditDialog() {
        JDialog editDialog = new JDialog();
        editDialog.setTitle("Edit Profile");
        editDialog.setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Weight:"));
        JTextField weightField = new JTextField();
        panel.add(weightField);

        panel.add(new JLabel("Height:"));
        JTextField heightField = new JTextField();
        panel.add(heightField);

        panel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String weight = weightField.getText();
                String height = heightField.getText();
                String password = new String(passwordField.getPassword());
                editDialog.dispose();
            }
        });

        editDialog.add(panel, BorderLayout.CENTER);
        editDialog.add(saveButton, BorderLayout.SOUTH);

        editDialog.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new ProfileView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
