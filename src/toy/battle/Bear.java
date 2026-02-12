package toy.battle;

public class Bear extends Animal{
    public Bear(String name) {
        super(name, 60, 10,4);
    }
    @Override public String type() {return "BEAR";}
}
