import battlefield.Battlefield;
import creatures.*;

public class Main {
    public static void main(String[] args) {
        Creatures player = new Player("Василий Сварщик",15, 25, 50, 10 );
        Creatures monster = new Monster("Roshan", 35, 10, 30, 20);
        Battlefield bf = new Battlefield(player, monster);

        bf.process(player, monster);
        bf.process(player, monster);
        bf.process(player, monster);
        monster.medicine();
        bf.process(monster, player);
        bf.process(monster, player);
        player.medicine();
        bf.process(player, monster);
    }
}