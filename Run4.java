import java.awt.*;
import javax.swing.*;

// class Run4 is a tester-applet for the Die class
public class Run4 extends Run3 {
    protected Die myDie2;

    public static void main4() {
        new Run4().setVisible(true);
    }
    
    public Run4() {
        super();
    }

    @Override
    public void display(Graphics g) {
        super.display(g);
        myDie.paint(g); // paint the first die
        myDie2.paint(g); // paint the second die
    }

    @Override
    protected void processRollButton() {
        myDie.roll(canvas.getGraphics()); // reroll first die
        myDie2.roll(canvas.getGraphics()); // reroll second die
    }

    @Override
    protected void addDice() {
        myDie = new Die(0, 0);
        myDie.setSize(150);
        myDie2 = new Die(210, 50);
    }
}