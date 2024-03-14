import java.awt.*;
import javax.swing.*;

// class Run5 is a tester-applet for the Die class
public class Run5 extends Run4 {

    private JTextField minMsgField;
    private JTextField maxMsgField;
    private JTextField bothMsgField;
    private int minRoll;
    private int maxRoll;
    protected JTextField doublesMsgField;

    public static void main5() {
        new Run5().setVisible(true);
    }
    
    public Run5() {
        super();
    }

    @Override
    protected void addMessageFields(Container c) {
        super.addMessageFields(c);
        minMsgField = createDefaultTextField();
        c.add(minMsgField);
        maxMsgField = createDefaultTextField();
        c.add(maxMsgField);
        bothMsgField = createDefaultTextField();
        c.add(bothMsgField);
        doublesMsgField = createDefaultTextField();
        c.add(doublesMsgField);
    }
    
    protected JTextField createDefaultTextField() {
        JTextField textField = new JTextField("", 25);
        textField.setBackground(Color.white);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        return textField;
    }

    // @Override
    // public void display(Graphics g) {
        // super.display(g);
        // myDie2.paint(g); // paint the second die
    // }

    private void updateMinMax() {
        int sum = myDie.getCurrentValue() + myDie2.getCurrentValue();
        maxRoll = Math.max(maxRoll, sum);
        minRoll = Math.min(minRoll, sum);
    }

    @Override
    protected void processRollButton() {
        super.processRollButton();
        updateMinMax();
    }

    @Override
    protected void printMessages() {
        super.printMessages();
        minMsgField.setText("The minimum roll so far is " + minRoll);
        maxMsgField.setText("The maximum roll so far is " + maxRoll);
        bothMsgField.setText("The current die values are " + myDie + " and " + myDie2);
        
        if (myDie.equals(myDie2)) {
            doublesMsgField.setText("We have doubles");
        }
        else {
            doublesMsgField.setText("We don't have doubles");
        }
    }
    
    @Override
    protected void addDice() {
        super.addDice();
        minRoll = 1000;
        maxRoll = -1000;
        updateMinMax();
    }
}