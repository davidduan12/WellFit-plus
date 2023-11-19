package view;

import javax.swing.*;

public class LabelFTextPanel extends JPanel {
    LabelFTextPanel(JLabel label, JFormattedTextField textField) {
        this.add(label);
        this.add(textField);
    }
}
