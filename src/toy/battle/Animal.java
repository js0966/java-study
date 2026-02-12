package toy.battle;

public abstract class Animal {
    protected String name;
    protected int hp;
    protected int atk;
    protected int def;

    public Animal(String name, int hp, int atk, int def) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public String getName() {return name;}
    public int getHp() {return hp;}
    public boolean isAlive() {return hp > 0;}

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
    }

    public abstract String type();
}
