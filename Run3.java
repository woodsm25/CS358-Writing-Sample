import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Run3 extends Run2 {

    public static void main3() {
        new Run3().setVisible(true);
    }

    public Run3() {
        super();        
    }

    @Override
    protected void addDice() {
        super.addDice();
        myDie.setSize(150);
    }

    @Override
    protected void handleButtonEvent(ActionEvent ae) { 
        if(ae.getSource() == increaseButton) { 
            myDie.setSize(myDie.getSize() + 10);
        }
        else if(ae.getSource() == decreaseButton) { 
            myDie.setSize(myDie.getSize() - 10);
        }        
        
        repaint();
    }    
}