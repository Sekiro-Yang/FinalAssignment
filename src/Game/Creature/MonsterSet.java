package Game.Creature;

import java.util.ArrayList;

public class MonsterSet {
    ArrayList<Monster> monsters = new ArrayList<Monster>();

    //如果找到了对应id的Monster，返回对应的对象，如果没有找到，就返回null.
    public Monster get(String id){
        Monster monster = null;
        for(Monster item:monsters){
            if (true == id.equals(item.getId())){
                monster = item;
                break;
            }
        }
        return monster;
    }

    public MonsterSet() {}

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }
}
