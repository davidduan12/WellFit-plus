package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.LoggedIn.AddExercise.AddExerciseState;
import interface_adapter.LoggedIn.AddExercise.AddExerciseController;
import interface_adapter.LoggedIn.AddExercise.AddExerciseViewModel;

public class ExerciseView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "add exercise";
    private final AddExerciseViewModel addExerciseViewModel;

    private final JTextField exerciseInputField = new JTextField(15);
    private final JTextField exerciseDurationInputField = new JTextField(15);
    private final AddExerciseController addExerciseController;

    private final JButton addExercise;

    public ExerciseView(AddExerciseViewModel addExerciseViewModel, AddExerciseController addExerciseController) {
        this.addExerciseViewModel = addExerciseViewModel;
        this.addExerciseController = addExerciseController;
        addExerciseViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(addExerciseViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel exerciseInfo = new LabelTextPanel(new JLabel(addExerciseViewModel.EXERCISE_LABEL), exerciseInputField);

        LabelTextPanel durationInfo = new LabelTextPanel(new JLabel(addExerciseViewModel.LENGTH_LABEL), exerciseDurationInputField);

        JPanel buttons = new JPanel();
        addExercise = new JButton(addExerciseViewModel.ADD_BUTTON_LABEL);
        buttons.add(addExercise);
        addExercise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(addExercise)) {
                    AddExerciseState currentState = addExerciseViewModel.getState();
                    addExerciseController.execute(
                            currentState.getExerciseName(),
                            currentState.getExerciseLength()
                    );
                }
            }
        });

        exerciseInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AddExerciseState currentState = addExerciseViewModel.getState();
                String text = exerciseInputField.getText() + evt.getKeyChar();
                currentState.setExerciseName(text);
                addExerciseViewModel.setState(currentState);
            }
        });

        exerciseDurationInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                try {
                    // Ignore non-printable characters.
                    if (c > 31 && c < 127) {
                        AddExerciseState currentState = addExerciseViewModel.getState();
                        currentState.setExerciseLength(Integer.parseInt(exerciseDurationInputField.getText() + evt.getKeyChar()));
                        addExerciseViewModel.setState(currentState);
                    }
                } catch (NumberFormatException nfe) {
                    // Do nothing
                }
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(exerciseInfo);
        this.add(durationInfo);
        this.add(addExercise);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // Handle action events if needed
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == addExerciseViewModel) {
            exerciseInputField.setText("");
            exerciseDurationInputField.setText("");
        }
    }
}