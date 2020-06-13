package Game.Creature;

import Game.Equipment.Equipment;
import Game.Weapon.Weapon;

import java.util.ArrayList;

public class Person extends Creature{
    private boolean RadiationState = false;
    private ArrayList<Equipment> equipments = new ArrayList<>();
    private ArrayList<Weapon> weapons = new ArrayList<>();

    public boolean isRadiationState() {
        return RadiationState;
    }

    public void setRadiationState(boolean radiationState) {
        RadiationState = radiationState;
    }

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(ArrayList<Equipment> equipments) {
        this.equipments = equipments;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }


    @Override
    public void useArticle(Weapon weapon, Creature creature){
        creature.setHPValue(creature.getHPValue() - weapon.getDamagePoints());
    }

    public void useDrug(Person person){
        person.setHPValue(person.getHPValue() + 50);
    }

    public void useSuit(Person person){
        person.setRadiationState(true);
    }

    public void useEquipment(Person person , String equ){
        for (Equipment item:equipments){
            if (equ.equals(item.getId())){
                if (item.getId().equals("FirstAid")){
                    useDrug(person);
                    System.out.println("使用" + item.getDescription() + "成功，血量+50");
                    System.out.println("目前你的血量为：" + person.getHPValue());
                }else if (item.getId().equals("Suit")){
                    useSuit(person);
                    item.setGetState(true);
                    System.out.println("成功装备" + item.getDescription());
                }else{
                    System.out.println("你输入的是非法指令");
                }
            }
        }
    }

    //返回武器的名称
    public String getWeaponsDiscreption(){
        StringBuffer sb = new StringBuffer();
        for (Weapon item : weapons){
            sb.append(item.getId());
            sb.append("(");
            sb.append(item.getUsetimes()) ;
            sb.append(") ");
        }
        return sb.toString();
    }
}
