package Framework;

/**
 * A Weapon object which can be given to an Npc or Player
 * */

public class Weapon {
    /**
     * Inner class to create a Weapon object
     */

    public static class Builder{

        String name;
        private Ability ability;
        private Sprite sprite;
        /**
         * Builder is used instead of a regular constructor
         * <br> <br>
         * Example usage: <br>
         * Weapong weapon = new Weapon.Builder(String name).build();
         * */
        public Builder(String name){
            this.name = name;
        }

        /**
         * Adds an Ability object to a Weapon <br>
         * @param ability Sets the Ability variable <br> <br>
         * Usage: <br>
         * new Weapon.Builder(String name).addAbility(Ability ability).build();
         * */
        public Builder addAbility(Ability ability){
            this.ability = ability;
            return this;
        }

        /**
         * Adds a specific sprite to a Weapon <br>
         * @param sprite Takes a Sprite object and adds it to a Weapon<br> <br>
         * Usage: <br>
         * new Weapon.Builder(String name).addSprite(Sprite sprite).build();
         * */
        public Builder addSprite(Sprite sprite){
            this.sprite = sprite;
            return this;
        }

        /**
         * Creates a Weapon object
         * @return  Returns a Weapon object with the given values.
         * */
        public Weapon build(){return new Weapon(this);}

    }

    String name;
    private Ability ability;
    private Sprite sprite;

    public Weapon(Builder builder) {
        this.name = builder.name;
        this.ability = builder.ability;
        this.sprite = builder.sprite;
    }


    //overwriter spriten til character, lagre den gamle
}