package view;

import interface_adapter.SignUp.SignupController;
import interface_adapter.SignUp.SignupState;
import interface_adapter.SignUp.SignupViewModel;
import interface_adapter.ViewManagerModel;

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
    private final ViewManagerModel viewManagerModel;
    final JTextField usernameInputField = new JTextField(15);
    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    final JTextField weightInputField = new JTextField(15);
    final JTextField heightInputField = new JTextField(15);
    private final SignupController signupController;

    final JButton signUp;
    private final JButton SwitchToLogin;

    public SignUpView(SignupController controller, SignupViewModel signupViewModel, ViewManagerModel viewManagerModel) {
        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;

        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel(SignupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel weightInfo = new LabelTextPanel(new JLabel(SignupViewModel.WEIGHT_LABEL), weightInputField);
        LabelTextPanel heightInfo = new LabelTextPanel(new JLabel(SignupViewModel.HEIGHT_LABEL), heightInputField);

        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);

        JPanel buttons = new JPanel();
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        SwitchToLogin = new JButton(SignupViewModel.LOGIN_LABEL);
        buttons.add(signUp);
        buttons.add(SwitchToLogin);


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

        SwitchToLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(SwitchToLogin)) {
                    viewManagerModel.setActiveView("log in");
                    viewManagerModel.firePropertyChanged();
                    SignupState currentState = signupViewModel.getState();
                    currentState.setWeight(0.0);
                    currentState.setHeight(0.0);
                    currentState.setRepeatPassword("");
                    currentState.setUsername("");
                    currentState.setPassword("");
                }
            }
        });


        weightInputField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                String text = weightInputField.getText() + e.getKeyChar();
                currentState.setWeight(Integer.parseInt(text));
                signupViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        heightInputField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                String text = heightInputField.getText() + e.getKeyChar();
                currentState.setHeight(Integer.parseInt(text));
                signupViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
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
        this.add(weightInfo);
        this.add(heightInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        SignupState state = (SignupState) evt.getNewValue();
//        if (state.getUsername() != null) {
//            JOptionPane.showMessageDialog(this, state.getUsername());
//        }
//    }
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();

        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
            signupViewModel.firePropertyChanged();
        } else if (state.getPasswordError() != null) {
            JOptionPane.showMessageDialog(this, state.getPasswordError());
            signupViewModel.firePropertyChanged();
        } else if (state.getRepeatPasswordError() != null) {
            JOptionPane.showMessageDialog(this, state.getRepeatPasswordError());
            signupViewModel.firePropertyChanged();
        }
    }
}