import java.awt.*;
import java.util.Random;

public class Die {

    private int currentValue;
    private int size;
    private int xCoord;
    private int yCoord;
    private final Random rand;

    public Die() {
        this.rand = new Random();
        this.size = 50;
        reRoll();
    }

    public Die(int xCoord, int yCoord) {
        this();
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    /**
     * Students may be wondering why we separate the roll(), reRoll() and paint() functionality. This is a good
     * opportunity to explain MVC (model view controller) to students:
     *
     * Model - the instance variables of the Die class
     * View - the paint() method
     * Controller - the roll() method in the Die class
     *
     * The functionality of all three of these is kept separate to improve readability, scalability, and
     * to help with debugging: if something is wrong with the display, or the values of the Die, then you know exactly
     * where to look. It also makes the program easier to modify in the future.
     */
    public void roll(Graphics g) {
        reRoll();
        paint(g);
    }

    private void reRoll() {
        this.currentValue = rand.nextInt(6) + 1;
    }

    private void drawSpot(Graphics g, int xPos, int yPos) {

    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(this.xCoord, this.yCoord, this.size, this.size);
        g.setColor(Color.BLACK);
        g.drawRect(this.xCoord, this.yCoord, this.size, this.size);

        g.drawString(Integer.toString(this.currentValue), this.xCoord + this.size / 2, this.yCoord + this.size / 2);
        /**
         * Students are asked to setup their paint method to draw a different die based on currentValue.
         * Using a switch statement is good practice when you have a lot of conditions you need to check:
         * 1: It makes the code easier to read and expand.
         * 2: It can be faster than chaining if-else statements when there's multiple conditions: this is because,
         * in a chain of if-else statements, the JVM might check every single condition. In a switch statement,
         * the JVM will calculate which branch to go to based on the input, bypassing conditional checks.
         */
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    @Override
    public String toString() {
        return Integer.toString(this.currentValue);
    }

    public boolean equals(Die d) {
        return d.toString().equals(this.toString());
    }
}