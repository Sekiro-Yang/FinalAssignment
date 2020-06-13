package Game.Room;

import Game.Creature.Monster;
import Game.Creature.Person;
import Game.Equipment.Equipment;
import Game.Equipment.EquipmentDefense;
import Game.Equipment.EquipmentDrug;
import Game.Weapon.Weapon;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String decription;
    private Equipment exitequipment;
    private Weapon exitsweapon;
    private EquipmentDefense exitsequipmentdenfense;
    private EquipmentDrug exitsequipmentdurg;
    private Monster monster;
    private Person person;
    private int damagePoint;
    private ArrayList<String> directions= new ArrayList<>();
    private HashMap<String,Room> exits = new HashMap<String,Room>();

    public Room() {
    }

    public Room(String decription) {
        this.decription = decription;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Weapon getExitsweapon() {
        return exitsweapon;
    }

    public void setExitsweapon(Weapon exitsweapon) {
        this.exitsweapon = exitsweapon;
    }

    public EquipmentDefense getExitsequipmentdenfense() {
        return exitsequipmentdenfense;
    }

    public void setExitsequipmentdenfense(EquipmentDefense exitsequipmentdenfense) {
        this.exitsequipmentdenfense = exitsequipmentdenfense;
    }

    public EquipmentDrug getExitsequipmentdurg() {
        return exitsequipmentdurg;
    }

    public void setExitsequipmentdurg(EquipmentDrug exitsequipmentdurg) {
        this.exitsequipmentdurg = exitsequipmentdurg;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Person getPerson() {
        return person;
    }

    public int getDamagePoint() {
        return damagePoint;
    }

    public void setDamagePoint(int damagePoint) {
        this.damagePoint = damagePoint;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    //设置房间的方向
    public void setExits(String dir , Room room){
        exits.put(dir,room);
    }

    //返回房间的方向
    public String getExitsdes(){
        StringBuffer sb = new StringBuffer();
        for (String dir : exits.keySet()){
            sb.append(dir);
            sb.append(" ");
        }
        return sb.toString();
    }

    //返回房间方向的集合
    public ArrayList<String> getExitsdir(){
        for (String dir:exits.keySet()) {
            directions.add(dir);
        }
        return directions;
    }

    //返回方向对应的房间
    public Room getExit(String direction){ //前往下一个房间
        return exits.get(direction);  //get  direction的那个房间，如果不存在那个方向就是null,如果存在就返回那个direction的房间
    }
}
