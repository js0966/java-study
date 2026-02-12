package toy.battle;

public class Rabbit extends Animal {
    public Rabbit(String name) {
        super(name, 60, 10, 4);
    }
    @Override
    public String type() {
        return "Rabbit";
    }
}
