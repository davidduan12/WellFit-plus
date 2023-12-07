package view;

import interface_adapter.SignUp.SignupState;
import interface_adapter.SignUp.SignupViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;
    private final ViewManagerModel viewManagerModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);

    private final JButton login;
    private final JButton SwitchToSignup;
    /**
     * A window with a title and a JButton.
     */
    public LoginView(LoginViewModel loginViewModel, LoginController loginController, ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.loginController = loginController;
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(loginViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel(loginViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel(loginViewModel.PASSWORD_LABEL), passwordInputField);


        JPanel buttons = new JPanel();
        login = new JButton(LoginViewModel.LOGIN_BUTTON_LABEL);
        SwitchToSignup = new JButton(LoginViewModel.SWITCH_BUTTON_LABEL);

        buttons.add(login);
        buttons.add(SwitchToSignup);


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                String text = usernameInputField.getText() + e.getKeyChar();
                currentState.setUsername(text);
                loginViewModel.setState(currentState);
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
                LoginState currentState = loginViewModel.getState();
                currentState.setPassword(new String(passwordInputField.getPassword()) + e.getKeyChar());
                loginViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(login)) {
                    LoginState currentState = loginViewModel.getState();
                    loginController.execute(
                            currentState.getUsername(),
                            currentState.getPassword()
                    );
                    System.out.println(viewManagerModel.getActiveView());
                }
            }
        });

        SwitchToSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(SwitchToSignup)) {
                    viewManagerModel.setActiveView("sign up");
                    viewManagerModel.firePropertyChanged();
                    LoginState currentState = loginViewModel.getState();
                    currentState.setUsername("");
                    currentState.setPassword("");

                }
            }
        });
        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);

    }


    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();

        if (state.getError() != null){
            JOptionPane.showMessageDialog(this, state.getError());
            state.setError(null);
        }
    }
}