package Framework.Backend;

import java.awt.*;

public abstract class GameObject {
    protected Position position;


    public int width, height, xPos, yPos;

    public GameObject(){
        width = 50;
        height = 50;
        position = new Position(100, 100);
    }
    public abstract void update();
    public abstract Image getSprite();

    public Position getPosition() {
        return position;
    }


    //setSize og setPosition, kan gi input fra klassen som extender (character/player)

    public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }
}
