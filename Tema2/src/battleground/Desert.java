package battleground;

import abilities.knight.Execute;
import abilities.knight.Slam;
import abilities.pyromancer.Fireblast;
import abilities.pyromancer.Ignite;
import abilities.rogue.Backstab;
import abilities.rogue.Paralysis;
import abilities.wizard.Deflect;
import abilities.wizard.Drain;
import characters.Knight;
import characters.Pyromancer;
import characters.Rogue;
import characters.Wizard;

public class Desert implements Location {


    @Override
    public String toString() {
        return "D ";
    }

    @Override
    public float cellModifier(Execute execute) {
        return 1f;
    }

    @Override
    public float cellModifier(Slam slam) {
        return 1f;
    }

    @Override
    public float cellModifier(Fireblast fireblast) {
        return 1f;
    }

    @Override
    public float cellModifier(Ignite ignite) {
        return 1f;
    }

    @Override
    public float cellModifier(Drain drain) {
        return 1.1f;
    }

    @Override
    public float cellModifier(Deflect deflect) {
        return 1.1f;
    }

    @Override
    public float cellModifier(Backstab backstab) {
        return 1f;
    }

    @Override
    public float cellModifier(Paralysis paralysis) {
        return 1f;
    }
}
