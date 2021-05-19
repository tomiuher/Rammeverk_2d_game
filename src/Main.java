import Framework.*;

public class Main {
    public static void main(String[] args) {

        Player p = new Player.Builder("p1").addSize(100,100).build();

        Npc n = new Npc.Builder("npcMan").addSize(200, 200).build();
        Npc n2 = new Npc.Builder("npcMan").addSize(10, 10).build();

        Game g = Game.getGame();

        g.addPlayer(p);
        g.addNpc(n, 150, 50);
        g.addNpc(n2, 1, 1);
        g.addNpc(n2, 10, 10);

        g.start();

    }
}
