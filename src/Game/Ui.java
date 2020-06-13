package Game;

import Game.Creature.Creature;
import Game.Creature.Monster;
import Game.Creature.Person;
import Game.Equipment.Equipment;
import Game.Room.Room;
import Game.Weapon.Weapon;

import java.util.Scanner;

public class Ui {

    Utils utils = new Utils();

    public void displayMap(Sense sense){
        System.out.println("游戏地图：");
        System.out.println("你现在在：" + sense.getCurrentRoom().getDecription());
        System.out.println("                                                    ————>east   ");
        System.out.println("                 |------|         |------|         |------|     ");
        System.out.println("                 |      |         |      | ------- |      |     ");
        System.out.println("                 |------|         |------|         |------|     ");
        System.out.println("                MedicalRoom      WaterRoom         DiningRoom   ");
        System.out.println("                     |               |                |         ");
        System.out.println("                     |               |                |         ");
        System.out.println("|------|         |------|         |------|         |------|     ");
        System.out.println("|      | ------- |      | ------- |      | ------- |      |     ");
        System.out.println("|------|         |------|         |------|         |------|     ");
        System.out.println("ExitRoom            Gym           ColdRoom          Bedroom     ");
        System.out.println("                    |                |                |         ");
        System.out.println("                    |                |                |         ");
        System.out.println("                 |------|         |------|         |------|     ");
        System.out.println("                 |      | ------- |      | ------- |      |     ");
        System.out.println("                 |------|         |------|         |------|     ");
        System.out.println("                StorageRoom       PowerRoom         Library     ");
    }

    public void displayStaus(Sense sense){
        System.out.println("-----------------------");
        System.out.println("目前你所在房间为：" + sense.getCurrentRoom().getDecription() + "\n" + "辐射值为：" + sense.getCurrentRoom().getDamagePoint());
        System.out.println("出口有：" + sense.getCurrentRoom().getExitsdes());
        System.out.println("-----------------------");
        System.out.println("该房间中：");
        if (sense.getCurrentRoom().getMonster() != null && sense.getCurrentRoom().getMonster().getHPValue() > 0){
            System.out.print(
                    "有" + sense.getCurrentRoom().getMonster().getDescription() + ":" + sense.getCurrentRoom().getMonster().getHPValue() + "(" + sense.getCurrentRoom().getMonster().getId() + ") ");
        }else{
            System.out.print("没有变异生物"+"  ");
        }
        if (sense.getCurrentRoom().getExitsequipmentdenfense() != null && sense.getCurrentRoom().getExitsequipmentdenfense().isPickState() == false){
            System.out.print("有" + sense.getCurrentRoom().getExitsequipmentdenfense().getDescription() + "("+sense.getCurrentRoom().getExitsequipmentdenfense().getId() + ")  ");
        }
        if (sense.getCurrentRoom().getExitsequipmentdurg()!=null && sense.getCurrentRoom().getExitsequipmentdurg().isPickState() == false){
            System.out.print("有" + sense.getCurrentRoom().getExitsequipmentdurg().getDescription() + "("+sense.getCurrentRoom().getExitsequipmentdurg().getId() + ")  ");
        }
        if (sense.getCurrentRoom().getExitsweapon() != null && sense.getCurrentRoom().getExitsweapon().isPickState() == false){
            System.out.print("有" + sense.getCurrentRoom().getExitsweapon().getDescription() + "("+sense.getCurrentRoom().getExitsweapon().getId() + ")  ");
        }
        System.out.println();
        System.out.print("你的生命值为：");
        if (sense.getPerson().isRadiationState() == false){
            sense.getPerson().setHPValue(sense.getPerson().getHPValue() - sense.getCurrentRoom().getDamagePoint());
            System.out.println(sense.getPerson().getHPValue());
            System.out.println("Warning：你还没有装备辐射防护服，请及时装备！");
        }else{
            System.out.println(sense.getPerson().getHPValue());
            System.out.println("你已装备辐射防护服");
        }
        System.out.println("-----------------------");
    }

    public void displayHelpMsg(){
        System.out.println("你可以输入的命令有：attack, go, pick, open, bye, help, map\n" +
                "attack: attack + 攻击对象 可以对攻击对象产生一定伤害\n" +
                "go：输入该房间存在的方向，可以前往下一个房间\n" +
                "pick：pick + 装备、武器或药品 可以将它们放入你的背包中\n" +
                "open：查看背包\n"+
                "bye:结束游戏\n" +
                "help：游戏指南\n" +
                "map：查看游戏地图\n" +
                "-----------------------");
    }

    public void displayGo(Sense sense,String dir){
        Room nextRoom = sense.getCurrentRoom().getExit(dir);

        if (nextRoom == null){
            System.out.println("那里没有门");
            System.out.println("-----------------------");
        }else{
            sense.setCurrentRoom(nextRoom);
            displayStaus(sense);
        }
    }

    public void displayBye(){
        System.out.println("游戏结束,欢迎再来！");
        System.out.println("-----------------------");
        System.exit(0); //退出程序

    }

    public void displayErrorCmdMsg(){
        System.out.println("你输入的是非法命令!");
        System.out.println("-----------------------");
    }

    public void displayBattle(Person person, Creature creature) {
        System.out.println("请选择攻击武器：");
        System.out.println(person.getWeaponsDiscreption());

        Scanner in = new Scanner(System.in);
        String command = in.nextLine();

        for (Weapon item:person.getWeapons()){
            if (command.equals(item.getId())){
                person.setCurrentWeapon(item);
                break;
            }else{
                person.setCurrentWeapon(null);
            }
        }

        if (creature == null) {
            System.out.println("你打了个寂寞");
        } else {
            //人砍妖怪
            if (person.getCurrentWeapon() != null){
                if (creature.getHPValue() != 0) {
                    person.useArticle(person.getCurrentWeapon(), creature);
                    if (person.getCurrentWeapon().getUsetimes() > 0){
                        System.out.println(person.getDescription() + "使用" +person.getCurrentWeapon().getDescription() + "对" + creature.getDescription() + "造成" +
                                person.getCurrentWeapon().getDamagePoints() + "点伤害！");
                        person.getCurrentWeapon().setUsetimes(person.getCurrentWeapon().getUsetimes() - 1);
                        System.out.println(person.getCurrentWeapon().getDescription() + "使用次数-1");
                    } else {
                        System.out.println("使用次数已用完，请选择其他武器攻击");
                    }
                }
            }else{
                System.out.println("你没有这个武器");
            }


            //妖怪随机砍人
            if (1 == utils.randomMonsterChop() && creature.getHPValue() != 0) {
                creature.useArticle(creature.getCurrentWeapon(), person);
                System.out.println(creature.getDescription() + "使用" +creature.getCurrentWeapon().getDescription() + "对" + person.getDescription() + "造成" +
                        creature.getCurrentWeapon().getDamagePoints() + "点伤害！");
            } else {
                System.out.println(creature.getDescription() + "错过了攻击机会！");
            }
            if (creature.getHPValue() <= 0){
                System.out.println(creature.getId() + "已死亡");
            }
        }
    }

    public void displayWinOrLose(Sense sense){
        int flag = 0;
        for (Monster item:sense.getMonsterSet().getMonsters()) {
            if (item.getHPValue()<=0){
                flag++;
            }
        }
        if (sense.getPerson().getHPValue() <= 0){
            System.out.print(sense.getPerson().getId() + "死亡，游戏结束");
            displayBye();
            System.exit(0); //退出程序
        }else if((flag == sense.getMonsterSet().getMonsters().size())){
            System.out.println("怪物被全部击败，玩家胜利！");
            System.out.println("-----------------------");
            System.exit(0); //退出程序
        }else{}
    }

    public void displayPick(Sense sense , String equ){
        if (sense.getCurrentRoom().getExitsweapon()!=null ||
                sense.getCurrentRoom().getExitsequipmentdurg() != null ||
                sense.getCurrentRoom().getExitsequipmentdenfense() != null){
            if (sense.getCurrentRoom().getExitsweapon()!=null && equ.equals(sense.getCurrentRoom().getExitsweapon().getId())){
                //如果玩家输入的字符与武器id匹配则加入玩家的武器背包
                sense.getPerson().getWeapons().add(sense.getCurrentRoom().getExitsweapon());
                System.out.println("获得" + sense.getCurrentRoom().getExitsweapon().getDescription());
                sense.getCurrentRoom().getExitsweapon().setPickState(true);
                System.out.println("-----------------------");
            } else if (sense.getCurrentRoom().getExitsequipmentdurg() != null && equ.equals( sense.getCurrentRoom().getExitsequipmentdurg().getId())  ){
                sense.getPerson().getEquipments().add(sense.getCurrentRoom().getExitsequipmentdurg());
                System.out.println("获得" + sense.getCurrentRoom().getExitsequipmentdurg().getDescription());
                sense.getCurrentRoom().getExitsequipmentdurg().setPickState(true);
                System.out.println("-----------------------");
            } else if (sense.getCurrentRoom().getExitsequipmentdenfense() != null && equ.equals(sense.getCurrentRoom().getExitsequipmentdenfense().getId())){
                sense.getPerson().getEquipments().add(sense.getCurrentRoom().getExitsequipmentdenfense());
                System.out.println("获得" + sense.getCurrentRoom().getExitsequipmentdenfense().getDescription());
                sense.getCurrentRoom().getExitsequipmentdenfense().setPickState(true);
                System.out.println("-----------------------");
            }else{
                System.out.println("输入错误");
            }
        }else{
            System.out.println("房间中没有装备可捡");
        }

    }

    public void displayKnapsack(Sense sense){
        if (sense.getPerson().getWeapons() != null){
            System.out.println("武器：");
            for (Weapon weapon:sense.getPerson().getWeapons()){
                System.out.println(weapon.getDescription() + "(" +weapon.getId() +  ")  伤害值：" + weapon.getDamagePoints() + "  使用次数：" + weapon.getUsetimes());
            }
        }
        if (sense.getPerson().getEquipments() != null){
            System.out.println("装备和物品：");
            for (Equipment equipment:sense.getPerson().getEquipments()){
                if (equipment.isGetState() == false){
                    System.out.println(equipment.getDescription() + "(" + equipment.getId() +")");
                }
            }
        }
        displayOpenSecond(sense);
    }

    public void displayOpenSecond(Sense sense){
        System.out.println("use：use + 装备或物品，使用装备和物品(注意不能use武器)");
        System.out.println("若没有可用装备，按任意键返回");
        System.out.println("-----------------------");
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        String[] words = command.split(" ");

        if (words[0].equals("use")){
            displayUse(sense,words[1]);
        }
    }

    public void displayUse(Sense sense , String equ){
        for (Equipment item:sense.getPerson().getEquipments()){
            if (equ.equals(item.getId())){
                sense.getPerson().useEquipment(sense.getPerson(),equ);
            }else{
                System.out.println("该装备或物品不存在（注意在当前状态下不能使用武器）");
                System.out.println("-----------------------");
            }
        }
    }
}
