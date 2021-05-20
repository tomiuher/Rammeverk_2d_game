package Framework.Backend;

import Framework.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Create a display which is shown on screen <br>
 * Gets created by the Game class
 */
public class Display extends JFrame{

    private Canvas canvas;
    int width = 500;
    int height = 400;
    static Input input;


    /**
     * Constructor for Display
     * @param input Input for the game
     */
    public Display(Input input){
        setTitle("Main Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //closing window stops program
        setResizable(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(1000,1000));
        canvas.setMinimumSize(new Dimension(10, 10));

        canvas.setFocusable(false);
        add(canvas); //adds to display (JFrame function)
        addKeyListener(input);
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Renders the game with all gameObjects
     * @param game The game to be rendered
     */
    public void render(Game game){
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        game.getGameObjects().forEach(gameObject -> graphics.drawImage(
                    gameObject.createDefaultSprite(),
                    gameObject.getPosition().getX(),
                    gameObject.getPosition().getY(),
                    null
            ));

        graphics.dispose();
        bufferStrategy.show();
    }

    /**
     * @return Returns the input variable
     */
    public static Input getInput() {
        return input;
    }

    /**
     * Sets the window size, is called via Game
     * @param width The new width of the window
     * @param height The new height of the window
     */
    public void setSize(int width, int height) {
        this.height = height;
        this.width = width;
        canvas.setPreferredSize(new Dimension(width, height));

    }
}
