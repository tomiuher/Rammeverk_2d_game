package Framework.Backend;

import java.awt.*;

/**
 * Abstract parent class for all game objects
 */
public abstract class GameObject {
    protected Position position;


    public int width, height;

    /**
     * Constructor for GameObject
     */
    public GameObject(){
        width = 50;
        height = 50;
        position = new Position(100, 100);
    }

    /**
     * Abstract method, implementation in child classes
     */
    public abstract void update();

    /**
     * Abstract method, implementation in child classes
     */
    public abstract Image createDefaultSprite();

    /**
     * @return Returns the position of the object
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the position of the object
     * @param x The position on the x axis
     * @param y The position on the x axis
     */
    public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }
}
