package Game.Creature;

import Game.Weapon.Weapon;

import java.util.ArrayList;

public class Creature {
    private String id;
    private String description;
    private int HPValue;

    private Weapon currentWeapon;
    ArrayList<Weapon> weapons = new ArrayList<Weapon>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHPValue() {
        return HPValue;
    }

    public void setHPValue(int HPValue) {
        this.HPValue = HPValue;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {  //生物装备武器，所以武器是属于生物的一种武器
        this.currentWeapon = currentWeapon;
    }

    public void useArticle(Weapon weapon , Creature creature){
        creature.setHPValue(creature.getHPValue() - weapon.getDamagePoints());
    }
}
