package Framework;

import java.util.ArrayList;
/**
 * A Menu object which is created by the user
 * */
public class Menu {

    /**
     * Inner class to create a Menu object
     */
    public static class Builder{

        private String name;
        private int width = 100, height = 100, posX = 1, posY = 1;
        private Option option;

        /**
         * Builder is used instead of a regular constructor
         * <br> <br>
         * Example usage: <br>
         * Menu menu = new Menu.Builder(String name).build();
         * */
        public Builder(String name){
            this.name = name;
        }

        /**
         * Adds a specific size to a Menu
         * Has a default value of 100x100 if not set <br>
         * @param width Sets the width variable
         * @param height Sets the height variable <br> <br>
         * Example usage: <br>
         * new Menu.Builder(String name).addSize(int width, int height).build();
         * */
        public Builder addSize(int width, int height){
            this.width = width;
            this.height = height;
            return this;
        }

        /**
         * Adds a specific opening position to the Menu object
         * Has a default value of 1x1 if not set <br>
         * @param posX Sets the X variable
         * @param posY Sets the Y variable <br> <br>
         * Usage: <br>
         * new Menu.Builder(String name).addPosition(int posX, int posY).build();
         * */
        public Builder addPosition(int posX, int posY){
            this.posX = posX;
            this.posY = posY;
            return this;
        }

        /**
         * Adds a option start position to the Menu object<br>
         * @param option Sets the option variable <br> <br>
         * Usage: <br>
         * new Menu.Builder(String name).addOption(Option option).build();
         * */
        public Builder addOption(Option option){
            this.option = option;
            return this;
        }


        /**
         * Creates a Menu object
         * @return  Returns a Menu object with the given values.
         * */
        public Menu build(){return new Menu(this);}

    }

    private String name;
    private int width, height, posX, posY;
    private Option option;

    private Menu(Builder builder) {
        this.name = builder.name;
        this.width = builder.width;
        this.height = builder.height;
        this.posX = builder.posX;
        this.posY = builder.posY;
        this.option = builder.option;

    }


   private class Option {
        String name;
        int index;

        public Option(String name, int index){
            this.name = name;
            this.index = index;
        }

   }






}
