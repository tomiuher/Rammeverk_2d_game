package Framework;

import Framework.Backend.Display;
import Framework.Backend.GameLoop;
import Framework.Backend.GameObject;
import Framework.Backend.Input;

import java.util.ArrayList;
import java.util.List;

/**
 * Game object singleton class
 */
public class Game {

    private static final Game game = new Game();
    private Display display;
    private List<GameObject> gameObjects;
    private Input input = new Input();
    private Player player;


    private Game(){
        display = new Display(input);
        gameObjects = new ArrayList<>();
    }

    /**
     * Gives a game object which the user can refer to
     * @return returns the game object singleton
     * Example usage: <br>
     * Game game = Game.getGame();
     */
    public static Game getGame(){
        return game;
    }

    /**
     * Adds a Player object to the game
     * @param player Sets the Player object variable
     */
    public void addPlayer(Player player){
        this.player = player;
        gameObjects.add(player);
    }

    /**
     * Adds an Npc object to the game
     * @param npc The Npc object to be added
     * @param posx Sets the y poistion of the object
     * @param posy Sets the x poistion of the object
     */
    public void addNpc(Npc npc, int posx, int posy){
        gameObjects.add(npc);

        GameObject go = gameObjects.get(gameObjects.indexOf(npc)); //kan ikke bruke samme npc fler ganger

        go.setPosition(posx, posy);
    }

    /**
     * Sets the size of the game window
     * @param width Sets the width of the game window
     * @param height Sets the height of the game window
     */
    public void setWindowSize(int width, int height){
        display.setSize(width,height);
    }

    /**
     * Starts the game <br>
     * Runs the game loop
     */
    public void start(){
        new Thread(new GameLoop(game)).start();
    }

    /**
     * Updates the game objects for each run of the game loop
     */
    public void update(){
        gameObjects.forEach(gameObject -> gameObject.update());
    }

    /**
     * Renders the game
     */
    public void render(){
        display.render(game);
    }

    /**
     * @return returns all the gameObjects
     */
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }


}
