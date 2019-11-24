package characters;


import abilities.Skill;

public abstract class Hero {

    private final int initialHP;
    private int level = 0;
    private int xp = 0;
    private PositionOnBattleground coords;



    Hero(final PositionOnBattleground coords, final int initialHP) {
        this.coords = coords;
        this.initialHP = initialHP;
    }

    Hero(int initialHP){
        this.initialHP = initialHP;
    }

    // For double dispatch
    public abstract void acceptFight(Hero hero);

    public abstract void fight(Knight knight);

    public abstract void fight(Rogue rogue);

    public abstract void fight(Pyromancer pyromancer);

    public abstract void fight(Wizard wizard);

    public void fight() {

    }

    public abstract void acceptRaceModifier(Skill skill);

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getInitialHP() {
        return initialHP;
    }

    public PositionOnBattleground getCoords() {
        return coords;
    }

    public void setCoords(PositionOnBattleground coords) {
        this.coords = coords;
    }
}
