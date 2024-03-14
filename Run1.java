import java.awt.*;

// class Run1 is a tester-applet for the Die class
public class Run1 extends RunAbstract {
    protected Die myDie;

    public static void main1() {
        new Run1().setVisible(true);
    }
    
    public Run1() {
        super();
    }

    @Override
    public void display(Graphics g) {
        super.display(g);
        myDie.paint(g); // paint the first die
    }

    @Override
    protected void processRollButton() {
        myDie.roll(canvas.getGraphics()); // reroll first die
    }

    @Override
    protected void addDice() {
        // create the die
        myDie = new Die();
    }
}