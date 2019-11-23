package characters;

public class Knight extends Hero {

    private float hp;

    Knight(PositionOnBattleground coords, int initialHP) {
        super(coords, initialHP);
    }

    Knight(final int initialHP) {
        super(initialHP);
    }

    @Override
    public void acceptFight(Hero hero) {
        hero.fight(this);
    }

    @Override
    public void fight(Knight knight) {

    }
    @Override
    public void fight(Pyromancer pyromancer) {

    }
    @Override
    public void fight(Wizard wizard) {

    }
    @Override
    public void fight(Rogue rogue) {

    }

    @Override
    public void LevelUp() {

    }

    @Override
    public void sufferEffects() {

    }

    @Override
    public String toString() {
        return "Knight{" +
                "hp=" + hp +
                '}';
    }
}
