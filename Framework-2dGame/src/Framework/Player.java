package Framework;

import Framework.Backend.*;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A Player object which is controlled by the user
 * */

public class Player extends GameObject {

    /**
     * Inner class to create a Player object
     */

    public static class Builder{
        private String name;
        private int posX, posY, movementSpeed, level, xp;
        private int width = 50;
        private int height = 50;
        private double movementSpeedMultiplier;
        private String up, down, left, right;
        private Sprite sprite;
        //TODO player må ha ability og attribute

        /**
         * Builder is used instead of a regular constructor
         * <br> <br>
         * Example usage: <br>
         * Player player = new Player.Builder(String name).build();
         * */
        public Builder(String name){
            this.name = name;
            //size, position, bilde, navn, input movementspeed
        }

        /**
         * Adds a specific size to a Player 
         * Has a default value of 50x50 if not set <br>
         * @param width Sets the width variable 
         * @param height Sets the height variable <br> <br>     
         * Usage: <br>
         * new Player.Builder(String name).addSize(int width, int height).build();
         * */
        public Builder addSize(int width, int height){
            this.width = width;
            this.height = height;
            return this;
        }

        /**
         * Adds a specific start position to the Player object
         * Has a default value of 100x100 if not set <br>
         * @param posX Sets the X variable 
         * @param posY Sets the Y variable <br> <br>     
         * Usage: <br>
         * new Player.Builder(String name).addPosition(int posX, int posY).build();
         * */
        public Builder addPosition(int posX, int posY){
            this.posX = posX;
            this.posY = posY;
            return this;
        }

        /**
         * Adds a specific movementSpeed to a Player 
         * Has a default value of 5 if not set <br>
         * @param movementSpeed Sets the movementSpeed variable <br> <br>     
         * Usage: <br>
         * new Player.Builder(String name).addMovementSpeed(int movementSpeed).build();
         * */
        public Builder addMovementSpeed(int movementSpeed){
            this.movementSpeed = movementSpeed;
            return this;
        }

        /**
         * Adds a movement speed multiplier to a Player
         * Used to add either walking or running <br>
         * @param movementSpeedMultiplier Sets the movementSpeedMultiplier variable <br> <br>
         * Usage: <br>
         * new Player.Builder(String name).addMovementSpeedMultiplier(double movementSpeedMultiplier).build();
         * */
        public Builder addMovementSpeedMultiplier(double movementSpeedMultiplier){
            this.movementSpeedMultiplier = movementSpeedMultiplier;
            return this;
        }

        /**
         * Adds a specific sprite to a Player
         * Sprite is set to a square by default <br>
         * @param sprite Takes a Sprite object and adds it to a Player<br> <br>
         * Usage: <br>
         * new Player.Builder(String name).addSprite(Sprite sprite).build();
         * */
        public Builder addSprite(Sprite sprite){
            this.sprite = sprite;
            return this;
        }

        /**
         * Adds specific input buttons to Player
         * Input is e by default <br>
         * @param up Takes a String KeyEvent.VK_keycode
         * @param down
         * @param left
         * @param right <br> <br>
         * Usage: <br>
         * new Player.Builder(String name).addSprite(Sprite sprite).build();
         * */
        //TODO: FIKSE INPUT doc og metode

        public Builder addInput(String up, String down, String left, String right){
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            return this;
        }

        /**
         * Adds a level variable to a Player <br>
         * @param level Sets the level variable<br> <br>
         * Usage: <br>
         * new Player.Builder(String name).addLevel(int level).build();
         * */
        public Builder addLevel(int level){
            this.level = level;
            return this;
        }

        /**
         * Adds a xp variable to a Player <br>
         * @param xp Sets the level variable<br> <br>
         * Usage: <br>
         * new Player.Builder(String name).addLevel(int level).build();
         * */
        //TODO GjØre ferdig addXp
        public Builder addXp(int xp){
            this.xp = xp;
            return this;
        }

        /**
         * Creates a Player object
         * @return  Returns a Player object with the given values.
         * */
        public Player build(){return new Player(this);}

    }

    private Controller controller;

    String name;
    int width, height, posX, posY, movementSpeed, level, xp;
    double movementSpeedMultiplier;
    String up, down, left, right;
    Sprite sprite;
    Input input;



    private Player(Builder builder){
        super();


        this.name = builder.name;
        this.width = builder.width;
        this.height = builder.height;
        this.posX = builder.posX;
        this.posY = builder.posY;
        this.movementSpeed = builder.movementSpeed;
        this.movementSpeedMultiplier = builder.movementSpeedMultiplier;
        this.level = builder.level;
        this.xp = builder.xp;
        this.up = builder.up;
        this.down = builder.down;
        this.left = builder.left;
        this.right = builder.right;
        this.sprite = builder.sprite;
        //this.controller = new PlayerController(Game.getInput());
        this.controller = new PlayerController(new Input()); //skal egt ha samme input som display

        //TODO få input til å fungere
    }


    @Override
    public void update() {
        int deltaX = 0;
        int deltaY = 0;

        if(controller.isRequestingUp()){
            deltaY -= movementSpeed;
        }

        if(controller.isRequestingDown()){
            deltaY += movementSpeed;
        }

        if(controller.isRequestingLeft()){
            deltaX -= movementSpeed;
        }

        if(controller.isRequestingRight()){
            deltaX += movementSpeed;
        }

        if(controller.isRequestingRight() && controller.isRequestingShft()){
            deltaX += (movementSpeed * movementSpeedMultiplier);
        }
        if(controller.isRequestingUp() && controller.isRequestingShft()){
            deltaY -= (movementSpeed * movementSpeedMultiplier);
        }

        if(controller.isRequestingDown() && controller.isRequestingShft()){
            deltaY += (movementSpeed * movementSpeedMultiplier);
        }

        if(controller.isRequestingLeft() && controller.isRequestingShft()){
            deltaX -= (movementSpeed * movementSpeedMultiplier);
        }

        if(controller.isRequestingRight() && controller.isRequestingShft()){
            deltaX += (movementSpeed * movementSpeedMultiplier);
        }
        position = new Position(position.getX() + deltaX, position.getY() + deltaY);


    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, width, height);

        graphics.dispose();
        return image;
    }


    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }



   /* public void setPlayerMovespeed(int speed){
        if (speed > 10){
            player.setMoveSpeed(10);
        } else
            player.setMoveSpeed(speed);
    } */
}
