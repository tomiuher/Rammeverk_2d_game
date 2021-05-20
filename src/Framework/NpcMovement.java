package Framework;

/**
 * An NpcMovement object which can be added to an Npc
 */
public class NpcMovement {

    /**
     * Inner class to create an NpcMovement object
     */
    public static class Builder{


        private int movementSpeed, up, down, left, right;
        private Player player;

        /**
         * Builder is used instead of a regular constructor
         * <br> <br>
         * Example usage: <br>
         * NpcMovement movement = new NpcMovement.Builder().build();
         * */
        public Builder(){}

        /**
         * Adds a pattern to an NpcMovement <br>
         * @param up Decides how far up the pattern should walk
         * @param down Decides how far down the pattern should walk
         * @param left Decides how far left the pattern should walk
         * @param right Decides how far right the pattern should walk <br><br>
         * Example usage: (walks up and down only) <br>
         * NpcMovement movement = new NpcMovement.Builder().addPattern(10, 10, 0 ,0).build();
         * */
        public Builder addPattern(int up, int down,int left, int right){
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            return this;
        }

        /**
         * Adds the followPlayer command to an NpcMovement <br>
         * @param player The player to move towards <br>
         * Every time the game updates this will look for the player's position and go towards that point <br><br>
         * Example usage: <br>
         * NpcMovement movement = new NpcMovement.Builder().addFollowPlayer(player1).build();
         * */
        public Builder addFollowPlayer(Player player){
            return this;
        }

        /**
         * Adds a speed variable to an NpcMovement <br>
         * @param movementSpeed The speed at which to move <br><br>
         * Example usage: <br>
         * NpcMovement movement = new NpcMovement.Builder().addSpeed(5).build();
         * */
        public  Builder addSpeed(int movementSpeed){
            this.movementSpeed = movementSpeed;
            return this;
        }

        /**
         * Creates an NpcMovement object
         * @return Returns an NpcMovement object with the given values
         * */
        public NpcMovement build(){
            return new NpcMovement(this);
        }
    }

    //set movement pattern, walk towards player, movement speed
    private int movementSpeed, up, down, left, right;
    private Player player;


    private NpcMovement(Builder builder){
        this.movementSpeed = builder.movementSpeed;
        this.up = builder.up;
        this.down = builder.down;
        this.left = builder.left;
        this.right = builder.right;
        this.player = builder.player;
    }



}