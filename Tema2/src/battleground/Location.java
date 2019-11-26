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

public interface Location {
    public float cellModifier(Execute execute);
    public float cellModifier(Slam slam);
    public float cellModifier(Fireblast fireblast);
    public float cellModifier(Ignite ignite);
    public float cellModifier(Drain drain);
    public float cellModifier(Deflect deflect);
    public float cellModifier(Backstab backstab);
    public float cellModifier(Paralysis paralysis);
}
