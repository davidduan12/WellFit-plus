package view;

import interface_adapter.SignUp.SignupController;
import interface_adapter.SignUp.SignupState;
import interface_adapter.SignUp.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignUpView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final JTextField weightInputField = new JTextField(15);
    private final JTextField heightInputField = new JTextField(15);
    private final SignupController signupController;

    private final JButton signUp;
    private final JButton cancel;
    private final JButton weightButton;
    private final JButton heightButton;

    public SignUpView(SignupController controller, SignupViewModel signupViewModel) {
        this.signupController = controller;
        this.signupViewModel = signupViewModel;

        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel(SignupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);

        JPanel buttons = new JPanel();
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);
        cancel = new JButton(SignupViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        weightButton = new JButton("Enter Weight");
        buttons.add(weightButton);

        heightButton = new JButton("Enter Height");
        buttons.add(heightButton);

        signUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(signUp)) {
                    SignupState currentState = signupViewModel.getState();

                    signupController.execute(
                            currentState.getUsername(),
                            currentState.getPassword(),
                            currentState.getRepeatPassword(),
                            currentState.getWeight(),
                            currentState.getHeight()
                    );
                }
            }
        });

        cancel.addActionListener(this);

        weightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String weight = JOptionPane.showInputDialog("Enter Weight (in kg):");
                if (weight != null) {
                    SignupState currentState = signupViewModel.getState();
                    currentState.setWeight(Double.parseDouble(weight));
                    weightInputField.setText(weight);
                    signupViewModel.setState(currentState);
                }
            }
        });

        heightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String height = JOptionPane.showInputDialog("Enter Height (in cm):");
                if (height != null) {
                    SignupState currentState = signupViewModel.getState();
                    currentState.setHeight(Double.parseDouble(height));
                    heightInputField.setText(height);
                    signupViewModel.setState(currentState);
                }
            }
        });

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                String text = usernameInputField.getText() + e.getKeyChar();
                currentState.setUsername(text);
                signupViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        passwordInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                currentState.setPassword(new String(passwordInputField.getPassword()) + e.getKeyChar());
                signupViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        repeatPasswordInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                currentState.setRepeatPassword(new String(repeatPasswordInputField.getPassword()) + e.getKeyChar());
                signupViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsername() != null) {
            JOptionPane.showMessageDialog(this, state.getUsername());
        }
    }
}