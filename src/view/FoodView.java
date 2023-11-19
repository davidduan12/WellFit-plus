package view;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import interface_adapter.AddFood.AddFoodState;
import view.LabelTextPanel;

import interface_adapter.AddFood.AddFoodController;
import interface_adapter.AddFood.AddFoodViewModel;
public class FoodView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";
    private final AddFoodViewModel addFoodViewModel;

    private final JTextField foodInputField = new JTextField(15);
    private final JTextField foodWeightInputField = new JTextField(15);
    private final AddFoodController addFoodController;


    private final JButton addFood;

    public FoodView(AddFoodController addFoodController, AddFoodViewModel addFoodViewModel){
        this.addFoodViewModel = addFoodViewModel;
        this.addFoodController = addFoodController;
        addFoodViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(addFoodViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel foodInfo = new LabelTextPanel(new JLabel(addFoodViewModel.FOOD_LABEL), foodInputField);

        LabelTextPanel weightInfo = new LabelTextPanel(new JLabel(addFoodViewModel.WEIGHT_LABEL), foodWeightInputField);

        JPanel buttons = new JPanel();
        addFood = new JButton(addFoodViewModel.ADD_BUTTON_LABEL);
        buttons.add(addFood);
        addFood.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(addFood)) {
                            AddFoodState currentState = addFoodViewModel.getState();
                            addFoodController.execute(
                                    currentState.getFoodName(),
                                    currentState.getFoodWeight()
                            );
                        }
                    }
                }
        );

        foodInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddFoodState currentState = addFoodViewModel.getState();
                        String text = foodInputField.getText() + e.getKeyChar();
                        currentState.setFoodName(text);
                        addFoodViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        foodWeightInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        try {
                            //Ignore non-printable characters.
                            if (c > 31 && c < 127){
                                AddFoodState currentState = addFoodViewModel.getState();
                                currentState.setFoodWeight(Integer.parseInt(foodWeightInputField.getText() + e.getKeyChar()));
                                addFoodViewModel.setState(currentState);
                            }
                        } catch (NumberFormatException nfe){
                            //do nothing
                        }

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(foodInfo);
        this.add(weightInfo);
        this.add(addFood);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt){
    //
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        }


}
