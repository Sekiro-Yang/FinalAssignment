package Game.Weapon;

import Game.Creature.Creature;

public class Weapon{
    private String id;
    private String description;
    private int damagePoints;
    private int usetimes;
    private boolean pickState = false;

    public void useArticle(Creature creature){
    }

    public Weapon() {
    }

    public Weapon(String id, String description, int damagePoints) {
        this.id = id;
        this.description = description;
        this.damagePoints = damagePoints;
    }

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

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public int getUsetimes() {
        return usetimes;
    }

    public void setUsetimes(int usetimes) {
        this.usetimes = usetimes;
    }

    public boolean isPickState() {
        return pickState;
    }

    public void setPickState(boolean pickState) {
        this.pickState = pickState;
    }
}
