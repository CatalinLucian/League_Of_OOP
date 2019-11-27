package characters;


import abilities.Effect;
import abilities.Skill;
import abilities.damage.DamagePerTurn;
import abilities.rogue.Paralysis;
import battleground.*;

import java.util.List;

public abstract class Hero {

    private boolean isDead = false;
    private final char type;
    private final int initialHP;
    private PositionOnBattleground coords;
    private int level = 0;
    private int xp = 0;
    private List<Directions> moves;
    private Skill firstSkill;
    private Skill secondSkill;
    private Effect effectSuffered;



    Hero(final PositionOnBattleground coords, final int initialHP, final char type) {
        this.coords = coords;
        this.initialHP = initialHP;
        this.type = type;
    }

    Hero(int initialHP, final char type){
        this.initialHP = initialHP;
        this.type = type;
    }


    public abstract int acceptRaceModifier(Skill skill);

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

    public List<Directions> getMoves() {
        return moves;
    }

    public void setMoves(List<Directions> moves) {
        this.moves = moves;
    }

    public abstract Skill getFirstSkill();
    public abstract Skill getSecondSkill();
    public abstract int getHp();
    public abstract void setHp(int hp);

    public Effect getEffectSuffered() {
        return effectSuffered;
    }

    public void setEffectSuffered(Effect effectSuffered) {
        this.effectSuffered = effectSuffered;
    }

    public void sufferEffect() {
        if(this.getEffectSuffered() instanceof DamagePerTurn && this.type == 'R') {
            this.setHp(Math.round(this.getHp() - ((DamagePerTurn) this.getEffectSuffered()).getDamage() * 0.8f));
        }
        if(this.getEffectSuffered() instanceof DamagePerTurn && this.type == 'P') {
            this.setHp(Math.round(this.getHp() - ((DamagePerTurn) this.getEffectSuffered()).getDamage() * 0.9f));
        }
        if(this.getEffectSuffered() instanceof DamagePerTurn && this.type == 'W') {
            this.setHp(Math.round(this.getHp() - ((DamagePerTurn) this.getEffectSuffered()).getDamage() * 1.05f));
        }

        if(this.getEffectSuffered() instanceof DamagePerTurn && this.type == 'K') {
            this.setHp(Math.round(this.getHp() - ((DamagePerTurn) this.getEffectSuffered()).getDamage() * 1.2f));
        }

        if(this.getEffectSuffered() instanceof Paralysis) {
            this.setHp(this.getHp() - this.acceptRaceModifier((Skill) this.getEffectSuffered()));
        }
    }

    public void setIsDead(final boolean t) {
        this.isDead = !this.isDead ? t : this.isDead;
    }

    public boolean isDead() {
        return isDead;
    }

    public char getType() {
        return type;
    }

    public void move() {

    }

    @Override
    public String toString() {
        if(isDead) {
            return type + " dead";
        }
        return type + " " + this.getLevel() + " " + this.getXp() + " " + this.getHp() + " " + this.getCoords().getRow() + " " + this.getCoords().getColumn();
    }
}
