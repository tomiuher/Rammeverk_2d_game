package Framework;

public class NpcMovement {


    //fast movement pattern, g[ mot playeren, movement speed
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

    public static class Builder{


        private int movementSpeed, up, down, left, right;
        Player player;


        public Builder(){}

        public Builder addPattern(int up, int down,int left, int right){
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            return this;
        }

        public Builder addFollowPlayer(Player player){
            return this;
        }

        public  Builder addSpeed(int movementSpeed){
            this.movementSpeed = movementSpeed;
            return this;
        }



        public NpcMovement build(){
            return new NpcMovement(this);
        }
    }



}