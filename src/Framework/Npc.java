package Framework;

import Framework.Backend.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * An Npc object
 * */
public class Npc extends GameObject {

    /**
     * Inner class to create an Npc object
     */
    public static class Builder{
        private String name;
        private final HashMap<String, Integer> attribute = new HashMap<>();
        private final ArrayList<Ability> abilityArray = new ArrayList<>();
        private Sprite image;
        private int level;
        private int width = 50;
        private int height = 50;
        private NpcMovement npcMovement;

        /**
         * Builder is used instead of a regular constructor
         * <br> <br>
         * Example usage: <br>
         * Npc npc = new Npc.Builder(String name).build();
         * */
        public Builder(String name){
            this.name = name;
        }

        /**
         * Adds an attribute variable to an Npc <br>
         * @param name Sets the attribute name <br>
         * @param value sets the attribute value <br><br>
         * Example usage: <br>
         * Npc npc = new Npc.Builder(String name).addAttribute(String name, int value).build();
         * */
        //TODO dette finnes ikke i player hvorfor?
        public Builder addAttribute(String name, int value){
            attribute.put(name, value);
            return this;
        }

        /**
         * Adds an Ability object to an Npc <br>
         * @param ability Sets the Ability variable <br> <br>
         * Example usage: <br>
         * Npc npc = new Npc.Builder(String name).addAbility(Ability ability).build();
         * */
        public Builder addAbility(Ability ability){
            abilityArray.add(ability);
            return this;
        }

        /**
         * Adds an Ability object to an Npc <br>
         *  Sets the Ability variable <br> <br>
         * Example usage: <br>
         * Npc npc = new Npc.Builder(String name).addAbility(Ability ability).build();
         * */
        //TODO skal dette være sprite??
        public Builder addImage(){

            return this;
        }

        /**
         * Adds a movement pattern to an Npc <br>
         * @param npcMovement Sets the npcMovement variable <br> <br>
         * Example usage: <br>
         * Npc npc = new Npc.Builder(String name).addMovement(NpcMovement npcMovement).build();
         * */
        //TODO revisit
        public Builder addMovement(NpcMovement npcMovement){
            this.npcMovement = npcMovement;
            return this;
        }

        /**
         * Adds a level to an Npc <br>
         * @param level Sets the level variable <br> <br>
         * Example usage: <br>
         * Npc npc = new Npc.Builder(String name).addlevel(int level).build();
         * */
        public Builder addLevel(int level){
            this.level = level;
            return this;
        }

        /**
         * Adds a level to an Npc <br>
         * @param width Sets the width variable
         * @param height Sets the height variable <br> <br>
         * Example usage: <br>
         * Npc npc = new Npc.Builder(String name).addlevel(int level).build();
         * */
        public Builder addSize(int width, int height){
            this.width = width;
            this.height = height;
            return this;
        }

        /**
         * Creates an Npc object
         * @return  Returns an Npc object with the given values.
         * */
        public Npc build(){
            return new Npc(this);
        }
    }

    private String name;
    private int level, width, height;
    private HashMap<String, Integer> attribute = new HashMap<>();
    private ArrayList<Ability> abilityArray = new ArrayList<>();
    private Sprite image;
    private NpcMovement npcMovement;


    private Npc(Builder builder) {
        this.name = builder.name;
        this.attribute = builder.attribute;
        this.abilityArray = builder.abilityArray;
        this.image = builder.image;
        this.npcMovement = builder.npcMovement;
        this.level = builder.level;
        this.width = builder.width;
        this.height = builder.height;
    }

    @Override
    public void update() {

    }

    @Override
    public Image createDefaultSprite() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.blue);
        graphics.fillRect(0, 0, width, height);

        graphics.dispose();
        return image;
    }

    /*
    public HashMap<String, Integer> getAllSkills() {
        return attribute;
    }

    public int getAttribute(String name) {
        return attribute.get(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     */

}

