package battlefield;

import creatures.Creatures;

public class Battlefield {
    int[] cube;

    public Battlefield() {
        this.cube = new int[]{1, 2, 3, 4, 5, 6,};
    }

    public void process(Creatures attacker, Creatures defending) {
        int attackMod = this.getAttackMod(attacker, defending);
        int[] results = this.diceRoll(attackMod);
        boolean check = this.checkResult(results);
        if (check){
            attacker.dealingDamage(defending);
        } else {
            System.out.printf("%s missed!!!\n", attacker.getName());
        }
    }

    private int getAttackMod(Creatures attacker, Creatures defending){
        return Math.abs(attacker.getAttack() - defending.getArmor()) + 1;
    }
    private int[] diceRoll(int numberOfCubes){
        int[] results = new int[numberOfCubes];
        for (int i = 0; i < numberOfCubes; i++) {
            results[i] = (int) (Math.random() * numberOfCubes);
        }
        return results;
    }
    private boolean checkResult(int[] results){
        for (int result : results) {
            if (result >= 5) return true;
        }
        return false;
    }
}
