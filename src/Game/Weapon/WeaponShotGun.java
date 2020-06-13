package Game.Weapon;

import Game.Creature.Creature;

public class WeaponShotGun extends Weapon{
    public WeaponShotGun(String id, String description,int damagePoints) {
        super(id,description,damagePoints);
    }

    @Override
    public void useArticle(Creature creature) {
        super.useArticle(creature);
    }
}
