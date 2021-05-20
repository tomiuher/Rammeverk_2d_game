package Framework;

import java.io.File;

/**
 * A Sprite object
 */
public class Sprite {

    private int width, height;

    /**
     * Constructor for Sprite
     * @param filename Name of the file. Must be saved in Res/Sprites
     * @param width Width of the sprite
     * @param height Height of the sprite
     */
    public Sprite(String filename, int width, int height){
        new File("./Res/Sprites/" + filename);
        this.width = width;
        this.height = height;
    }

    /**
     * Sets the width and height of Sprite
     * @param width Width of the sprite
     * @param height Height of the sprite
     */
    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }


}
