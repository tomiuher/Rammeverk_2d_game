package Framework.Backend;

import Framework.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame{

    private Canvas canvas;
    int width = 500;
    int height = 400;
    static Input input;



    public Display(Input input){
       // this.input = input;
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

        canvas.createBufferStrategy(3); //stops the screen from flickering?

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(Game game){
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        game.getGameObjects().forEach(gameObject -> graphics.drawImage(
                    gameObject.getSprite(),
                    gameObject.getPosition().getX(),
                    gameObject.getPosition().getY(),
                    null
            ));

        graphics.dispose();
        bufferStrategy.show();
    }

    public static Input getInput() {
        return input;
    }

    public void setSize(int width, int height) {
        this.height = height;
        this.width = width;
        canvas.setPreferredSize(new Dimension(width, height));

    }
}
