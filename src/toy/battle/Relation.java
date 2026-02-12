package toy.battle;

public class Relation {

    public static double getMultiplier(Species attacker, Species defender) {

        if (attacker == Species.WOLF && defender == Species.RABBIT) return 1.5;
        if (attacker == Species.BEAR && defender == Species.WOLF) return 1.5;
        if (attacker == Species.RABBIT && defender == Species.BEAR) return 1.5;

        return 1.0;
    }
}
