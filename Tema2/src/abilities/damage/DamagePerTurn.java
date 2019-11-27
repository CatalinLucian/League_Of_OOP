package abilities.damage;

import abilities.Effect;

public class DamagePerTurn extends Effect {
    private int damage;
    public DamagePerTurn(final int noOfRounds, final int damage) {
        super(noOfRounds);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
