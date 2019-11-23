package characters;


public class Rogue extends Hero {

    private float hp;

    Rogue(PositionOnBattleground coords, int initialHP) {
        super(coords, initialHP);
    }

    Rogue(final int initialHP) {
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
        return "Rogue{" +
                "hp=" + hp +
                '}';
    }
}
