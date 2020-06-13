package Game.Weapon;

import Game.Creature.Creature;

public class WeaponPistol extends Weapon{
    public WeaponPistol(String id, String description,int damagePoints) {
        super(id,description,damagePoints);
    }
    @Override
    public void useArticle(Creature creature) {
        super.useArticle(creature);
    }
}
