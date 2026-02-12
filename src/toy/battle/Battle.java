package toy.battle;

public class Battle {

    public static void fight(Animal a, Animal b) {
        System.out.println("\n== FIGHT START ===");
        System.out.println(info(a) + "vs" + info(b));

        boolean aTurn = true;
        while (a.isAlive() && b.isAlive()) {
            if (aTurn) {
                attack(a,b);
            } else {
                attack(b,a);
            }
            aTurn = !aTurn;
        }

        Animal winner = a.isAlive() ? a : b;
        System.out.println("WINNER: " + winner.type() + " " + winner.getName());
        System.out.println("=== FIGHT END ===\n");
    }

    private static void attack(Animal attacker, Animal target) {
        int raw = attacker.atk - target.def;
        int dmg = Math.max(1, raw);
        target.takeDamage(dmg);

        System.out.println(attacker.getName() + " hits " + target.getName()
                + " for " + dmg + " dmg"
                + " (HP " + target.getHp() + ")");
    }

    private static String info(Animal x) {
        return x.type() + " " + x.getName() + "(HP" + x.getHp() + ")";
    }
}
