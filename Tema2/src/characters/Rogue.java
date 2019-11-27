package characters;


import Constants.RogueConstants;
import abilities.Skill;
import abilities.rogue.Backstab;
import abilities.rogue.Paralysis;

public class Rogue extends Hero {

    private int hp = RogueConstants.INITIAL_HP;
    private final Skill firstSkill = new Paralysis(this);
    private final Skill secondSkill = new Backstab(this);

    Rogue(PositionOnBattleground coords, int initialHP) {
        super(coords, initialHP, 'R');
    }

    public Rogue(final int initialHP) {
        super(initialHP, 'R');
        hp = initialHP;
    }



    @Override
    public int acceptRaceModifier(Skill skill) {
        return skill.applyRaceModifier(this);
    }

    @Override
    public Skill getFirstSkill() {
        return firstSkill;
    }

    @Override
    public Skill getSecondSkill() {
        return secondSkill;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


}
