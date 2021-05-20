package Framework.Backend;

/**
 * Position object to store position of GameObjects
 */
public class Position {

    private int x;
    private int y;

    /**
     * Constructor for Position
     * @param x The position on the x axis
     * @param y The position on the x axis
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return Returns the position on the x axis
     */
    public int getX() {
        return x;
    }

    /**
     * @return Returns the position on the y axis
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the position on the x axis
     * @param x Sets the x variable
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the position on the y axis
     * @param y Sets the y variable
     */
    public void setY(int y) {
        this.y = y;
    }
}
