package Game.Weapon;

import Game.Creature.Creature;

public class WeaponBite extends Weapon{
    public WeaponBite(String id, String description, int damagePoints) {
        super(id, description, damagePoints);
    }

    @Override
    public void useArticle(Creature creature) {
        super.useArticle(creature);
    }
}
