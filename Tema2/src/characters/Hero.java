package characters;


public abstract class Hero {

    private int level = 0;
    private int xp = 0;

    // For double dispatch
    public abstract void acceptFight(Hero hero);

    public abstract void fight(Knight knight);

    public abstract void fight(Rogue rogue);

    public abstract void fight(Pyromancer pyromancer);

    public abstract void fight(Wizard wizard);

    public abstract void LevelUp();

    public abstract void sufferEffects();
}
