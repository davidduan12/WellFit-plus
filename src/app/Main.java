package app;

import view.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> {
            //Main window
            JFrame application = new MainFrame();
            application.setVisible(true);
        });

    }


}
