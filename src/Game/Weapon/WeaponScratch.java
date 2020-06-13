package Game.Weapon;

import Game.Creature.Creature;

public class WeaponScratch extends Weapon{
    public WeaponScratch(String id, String description, int damagePoints) {
        super(id, description, damagePoints);
    }

    @Override
    public void useArticle(Creature creature) {
        super.useArticle(creature);
    }
}
