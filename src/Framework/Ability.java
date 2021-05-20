package Framework;

/**
 * An Ability object which can be attached to an Npc or Player
 * */
public class Ability {

    /**
     * Inner class to create an Ability object
     */
    public static class Builder{
        private String name;
        private int damage, manaCost, cooldown;
        private Sprite sprite;

        /**
         * Builder is used instead of a regular constructor
         * <br> <br>
         * Example usage: <br>
         * Ability ability = new Ability.Builder(String name).build();
         * */
        public Builder(String name){
            this.name = name;
        }

        /**
         * Adds a damage variable to an Ability <br>
         * @param damage Sets the damage variable <br> <br>
         * Example usage: <br>
         * Ability ability = new Ability.Builder(String name).addDamage(int damage).build();
         * */
        public Builder addDamage(int damage) {
            this.damage = damage;
            return this;
        }

        /**
         * Adds a manaCost variable to an Ability <br>
         * @param manaCost Sets the manaCost variable <br> <br>
         * Example usage: <br>
         * Ability ability = Ability.Builder(String name).addManaCost(int manaCost).build();
         * */
        public Builder addManaCost(final int manaCost) {
            this.manaCost = manaCost;
            return this;
        }

        /**
         * Adds a cooldown variable to an Ability <br>
         * @param cooldown Sets the cooldown variable <br> <br>
         * Example usage: <br>
         * Ability ability = new Ability.Builder(String name).addCooldown(int cooldown).build();
         * */
        public Builder addCooldown(int cooldown) {
            this.cooldown = cooldown;
            return this;
        }

        /**
         * Adds a Sprite to an Ability object
         * @param sprite The sprite to be added to the Ability
         */
        public Builder addSprite(Sprite sprite) {
            this.sprite = sprite;
            return this;
        }

        /**
         * Creates an Ability object
         * @return  Returns an Ability object with the given values.
         * */
        public Ability build(){
            return new Ability(this);
        }
    }

    //Skal vi kommentere dette
    private String name;
    private final int damage, manaCost, cooldown;
    private Sprite sprite;

    private Ability(Builder builder) {
        this.name = builder.name;
        this.damage = builder.damage;
        this.cooldown = builder.cooldown;
        this.manaCost = builder.manaCost;
        this.sprite = builder.sprite;
    }

    /**
     * @return returns the Ability damage value
     * */
    public int getDamage() {
        return damage;
    }

    /**
     * @return returns the Ability manaCost value
     * */
    public int getManaCost() {
        return manaCost;
    }

    /**
     * @return returns the Ability cooldown value
     * */
    public int getCooldown() {
        return cooldown;
    }

}