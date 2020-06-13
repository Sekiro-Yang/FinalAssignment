package Game.Equipment;

public class Equipment {
    private String id;
    private String description;
    private boolean getState = false;
    private boolean pickState = false;

    public Equipment() {
    }

    public Equipment(String id, String description) {
        this.id = id;
        this.description = description;
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

    public boolean isGetState() {
        return getState;
    }

    public void setGetState(boolean getState) {
        this.getState = getState;
    }

    public boolean isPickState() {
        return pickState;
    }

    public void setPickState(boolean pickState) {
        this.pickState = pickState;
    }
}
