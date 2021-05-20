package Framework.Backend;

import Framework.Game;

/**
 * The Game loop <br>
 * Gets created by the Game class
 */
public class GameLoop implements Runnable{

    private final Game game;

    private boolean running;
    private final double updateRate = 1.0d/60.0d; //60 updates/second

    private long nextStatTime;
    private int fps, ups; //updates per second

    /**
     * Constructor for GameLoop
     * @param game The game to start a game loop for
     */
    public GameLoop(Game game){
        this.game = game;
    }

    /**
     * Runs the game loop
     */
    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;

        while(running){
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            if(accumulator >= updateRate){
                while(accumulator >= updateRate){
                    update();
                    accumulator -= updateRate;
                }
                render();
            }
            printStats();
        }
    }

    /**
     * Prints statistics of the game loop
     */
    private void printStats() {
        if(System.currentTimeMillis() > nextStatTime){
            System.out.printf("FPS: %d%n", fps);
            fps = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    /**
     * Updates the game
     */
    private void update() {
        game.update();
        ups++;
    }

    /**
     * Renders the game
     */
    private void render() {
        game.render();
        fps++;
    }
}
