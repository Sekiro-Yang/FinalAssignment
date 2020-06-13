package Game.Creature;

import Game.Weapon.Weapon;

public class MonsterCockroach extends Monster{
    @Override
    public void useArticle(Weapon weapon, Creature creature) {
        creature.setHPValue(creature.getHPValue() - weapon.getDamagePoints());
    }
}
