package toy.battle;

public class Battle {

    public static void fight(Animal a1, Animal a2) {

        System.out.println("=== BATTLE START ===");
        System.out.println(a1.getName() + " (" + a1.getSpecies() + ") vs "
                + a2.getName() + " (" + a2.getSpecies() + ")");

        boolean turn = true;

        while (a1.isAlive() && a2.isAlive()) {

            if (turn) {
                attack(a1, a2);
            } else {
                attack(a2, a1);
            }

            turn = !turn;
        }

        Animal winner = a1.isAlive() ? a1 : a2;
        System.out.println("Winner: " + winner.getName());
        System.out.println("=== BATTLE END ===");
    }

    private static void attack(Animal attacker, Animal defender) {

        double multiplier = Relation.getMultiplier(
                attacker.getSpecies(),
                defender.getSpecies()
        );

        int baseDamage = attacker.calculateBaseDamage(defender);
        if (baseDamage < 1) baseDamage = 1;

        int finalDamage = (int) (baseDamage * multiplier);

        defender.takeDamage(finalDamage);

        System.out.println(attacker.getName() +
                " attacks " +
                defender.getName() +
                " for " + finalDamage +
                " damage (HP left: " + defender.getHp() + ")");
    }
}
