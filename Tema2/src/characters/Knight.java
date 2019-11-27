package characters;

import Constants.KnightConstants;
import abilities.Skill;
import abilities.knight.Execute;
import abilities.knight.Slam;
import battleground.Land;
import battleground.Location;

public class Knight extends Hero {

    private int hp = KnightConstants.INITIAL_HP;
    private Skill firstSkill = new Execute(this);
    private Skill secondSkill = new Slam(this);

    Knight(PositionOnBattleground coords, int initialHP) {
        super(coords, initialHP, 'K');
    }

    public Knight(final int initialHP) {
        super(initialHP, 'K');
        hp = initialHP;
    }



    @Override
    public int acceptRaceModifier(Skill skill) {
        return skill.applyRaceModifier(this);
    }



    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public Skill getFirstSkill() {
        return  firstSkill;
    }

    @Override
    public Skill getSecondSkill() {
        return secondSkill;
    }
}
