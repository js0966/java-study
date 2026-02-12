package toy.battle;

public class Main {

    public static void main(String[] args) {

        Animal wolf = new Wolf("Choco");
        Animal bear = new Bear("Gom");
        Animal rabbit = new Rabbit("Bunny");

        Battle.fight(wolf, rabbit);
    }
}
