package Game.Creature;

import Game.Weapon.Weapon;

public class MonsterMonkey extends Monster{
    @Override
    public void useArticle(Weapon weapon, Creature creature) {
        creature.setHPValue(creature.getHPValue() - weapon.getDamagePoints());
    }
}
