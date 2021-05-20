package Framework.Backend;

import Framework.Game;

public class GameLoop implements Runnable{

    private final Game game;

    private boolean running;
    private final double updateRate = 1.0d/60.0d; //60 updates/second

    private long nextStatTime;
    private int fps, ups; //updates per second

    public GameLoop(Game game){
        this.game = game;
    }

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

    private void printStats() {
        if(System.currentTimeMillis() > nextStatTime){
            System.out.printf("FPS: %d%n", fps);
            fps = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    private void update() {
        game.update();
        ups++;
    }

    private void render() {
        game.render();
        fps++;
    }
}
