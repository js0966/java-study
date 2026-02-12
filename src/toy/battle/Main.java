package toy.battle;

public class Main {
    public static void main(String[] args) {

//        Animal[] animals = {
//                new Wolf("Choco"),
//                new Bear("Gom"),
//                new Rabbit("Bunny"),
//                new Wolf("Nero")
//        };
//
//        for (int i = 0; i < animals.length; i++) {
//            System.out.println(animals[i].type() + " " + animals[i].getName() + " Hp=" + animals[i].getHp());
//        }
        Animal a = new Wolf("Choco");
        Animal b = new Bear("Bada");

        Battle.fight(a, b);
    }
}
