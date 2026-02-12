package toy.battle;

public abstract class Animal {
    protected String name;
    protected int hp;
    protected int atk;
    protected int def;
    protected Species species;

    public Animal(String name, int hp, int atk, int def, Species species) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.species = species;
    }

    public String getName() {return name;}
    public int getHp() {return hp;}
    public boolean isAlive() {return hp > 0;}
    public Species getSpecies() {return species;}
    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
    }
    public int calculateBaseDamage(Animal target) {

        int safeDef = target.def;
        if (safeDef < 0) safeDef = 0;

        int damage = this.atk - safeDef;
        if (damage < 1) damage = 1;

        return damage;
    }

}
