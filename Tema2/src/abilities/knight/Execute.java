package abilities.knight;

import abilities.Skill;
import characters.Hero;

public class Execute implements Skill {

    private float baseDamage = 200;

    public float calculateHPLimit(Hero hero) {
        return 0.2f * hero.getInitialHP() + 0.01f * hero.getLevel();
    }

    @Override
    public void computeDamage() {

    }
}
