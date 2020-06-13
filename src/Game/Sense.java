package Game;

import Game.Creature.*;
import Game.Equipment.EquipmentDefense;
import Game.Equipment.EquipmentDrug;
import Game.Room.Room;
import Game.Room.RoomSet;
import Game.Weapon.*;

import java.util.Scanner;

public class Sense {

    //初始化人和怪物
    private Person person = new Person();
    private MonsterCockroach monsterCockroach = new MonsterCockroach();
    private MonsterDog monsterDog = new MonsterDog();
    private MonsterMonkey monsterMonkey = new MonsterMonkey();
    private MonsterPerson monsterPerson = new MonsterPerson();
    private MonsterPerson monsterPerson1 = new MonsterPerson();
    private MonsterSet monsterSet = new MonsterSet();
    private Room currentRoom = new Room();
    private RoomSet roomSet = new RoomSet();

    //初始化武器
    private WeaponAxe weaponAxe = new WeaponAxe("Axe","消防斧",50);
    private WeaponPistol weaponPistol= new WeaponPistol("Pistol","手枪",100);
    private WeaponShotGun weaponShotGun = new WeaponShotGun("ShotGun","散弹枪",200);
    private WeaponFist weaponFist = new WeaponFist("Punches","重拳出击",20);
    private WeaponBite weaponBite = new WeaponBite("Bite","咬击",30);
    private WeaponScratch weaponScratch= new WeaponScratch("Scratch","抓击",40);

    //初始化装备
    private EquipmentDrug equipmentDrug = new EquipmentDrug();
    private EquipmentDrug equipmentDrug1 = new EquipmentDrug();
    private EquipmentDrug equipmentDrug2 = new EquipmentDrug();
    private EquipmentDefense equipmentDefense = new EquipmentDefense();

    //初始化房间
    private Room MedicalRoom = new Room("MedicalRoom");
    private Room WaterRoom = new Room("WaterRoom");
    private Room DiningRoom = new Room("DiningRoom");
    private Room Gym = new Room("Gym");
    private Room ColdRoom = new Room("ColdRoom");
    private Room Bedroom = new Room("Bedroom");
    private Room StorageRoom = new Room("StorageRoom");
    private Room PowerRoom = new Room("PowerRoom");
    private Room Library = new Room("Library");
    private Room ExitRoom = new Room("ExitRoom");

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public MonsterSet getMonsterSet() {
        return monsterSet;
    }

    public void setMonsterSet(MonsterSet monsterSet) {
        this.monsterSet = monsterSet;
    }

    Ui ui = new Ui();
    Utils utils = new Utils();

    //初始化场景
    public void initSense() {
        initRoom();
        initPerson();
        initMonster();
    }

    //设置房间方向、武器、装备、药物
    public void initRoom(){
        //把所有房间放入房间列表中去
        roomSet.getRooms().add(MedicalRoom);
        roomSet.getRooms().add(WaterRoom);
        roomSet.getRooms().add(DiningRoom);
        roomSet.getRooms().add(Gym);
        roomSet.getRooms().add(ColdRoom);
        roomSet.getRooms().add(Bedroom);
        roomSet.getRooms().add(StorageRoom);
        roomSet.getRooms().add(PowerRoom);
        roomSet.getRooms().add(Library);
        roomSet.getRooms().add(ExitRoom);


        //设置房间的方向和对应的房间
        MedicalRoom.setExits("south",Gym);
        Gym.setExits("north",MedicalRoom);
        Gym.setExits("west",ExitRoom);
        Gym.setExits("south",StorageRoom);
        Gym.setExits("east",ColdRoom);
        StorageRoom.setExits("north",Gym);
        StorageRoom.setExits("east",PowerRoom);
        WaterRoom.setExits("east",DiningRoom);
        ColdRoom.setExits("east",Bedroom);
        ColdRoom.setExits("south",PowerRoom);
        ColdRoom.setExits("west",Gym);
        PowerRoom.setExits("north",ColdRoom);
        PowerRoom.setExits("west",StorageRoom);
        PowerRoom.setExits("east",Library);
        DiningRoom.setExits("west",WaterRoom);
        DiningRoom.setExits("south",Bedroom);
        Bedroom.setExits("north",DiningRoom);
        Bedroom.setExits("west",ColdRoom);
        Bedroom.setExits("south",Library);
        Library.setExits("north",Bedroom);
        Library.setExits("west",PowerRoom);
        ExitRoom.setExits("east",Gym);

        //设置房间的辐射伤害值
        MedicalRoom.setDamagePoint(30);
        WaterRoom.setDamagePoint(0);
        DiningRoom.setDamagePoint(10);
        ExitRoom.setDamagePoint(60);
        Gym.setDamagePoint(45);
        ColdRoom.setDamagePoint(0);
        Bedroom.setDamagePoint(10);
        StorageRoom.setDamagePoint(30);
        PowerRoom.setDamagePoint(15);
        Library.setDamagePoint(10);

        //初始化房间
        currentRoom = ColdRoom;

        //设置房间中的怪物和人
        ColdRoom.setPerson(person);
        DiningRoom.setMonster(monsterDog);
        Bedroom.setMonster(monsterMonkey);
        Gym.setMonster(monsterCockroach);
        StorageRoom.setMonster(monsterPerson);
        WaterRoom.setMonster(monsterPerson1);

        //设置道具的名称
        equipmentDefense.setDescription("辐射防护服");
        equipmentDrug.setDescription("急救包");
        equipmentDrug1.setDescription("急救包");
        equipmentDrug2.setDescription("急救包");

        equipmentDefense.setId("Suit");
        equipmentDrug.setId("FirstAid");
        equipmentDrug1.setId("FirstAid");
        equipmentDrug2.setId("FirstAid");


        //设置房间中的武器
        ColdRoom.setExitsweapon(weaponAxe);
        MedicalRoom.setExitsweapon(weaponPistol);
        ExitRoom.setExitsweapon(weaponShotGun);
        weaponAxe.setUsetimes(50);
        weaponPistol.setUsetimes(5);
        weaponShotGun.setUsetimes(2);
        weaponFist.setUsetimes(99999);
        //设置房间中的装备和药物
        MedicalRoom.setExitsequipmentdurg(equipmentDrug);
        DiningRoom.setExitsequipmentdurg(equipmentDrug1);
        PowerRoom.setExitsequipmentdurg(equipmentDrug2);
        ColdRoom.setExitsequipmentdenfense(equipmentDefense);
    }

    //设置人物
    public void initPerson() {
        person.setId("Person");
        person.setDescription("小杨");
        person.setHPValue(200);
        person.setCurrentWeapon(weaponFist);
        person.getWeapons().add(weaponFist);
    }

    //设置怪物
    public void initMonster() {
        monsterCockroach.setId("Cockroach");
        monsterCockroach.setDescription("变异螳螂");
        monsterCockroach.setHPValue(60);
        monsterCockroach.setCurrentWeapon(weaponScratch);
        monsterSet.getMonsters().add(monsterCockroach);

        monsterDog.setId("Dog");
        monsterDog.setDescription("变异狗");
        monsterDog.setHPValue(100);
        monsterDog.setCurrentWeapon(weaponBite);
        monsterSet.getMonsters().add(monsterDog);

        monsterMonkey.setId("Monkey");
        monsterMonkey.setDescription("变异猴");
        monsterMonkey.setHPValue(150);
        monsterMonkey.setCurrentWeapon(weaponScratch);
        monsterSet.getMonsters().add(monsterMonkey);

        monsterPerson.setId("Singer");
        monsterPerson.setDescription("变异人");
        monsterPerson.setHPValue(200);
        monsterPerson.setCurrentWeapon(weaponFist);
        monsterSet.getMonsters().add(monsterPerson);

        monsterPerson1.setId("Watcher");
        monsterPerson1.setDescription("变异人");
        monsterPerson1.setHPValue(200);
        monsterPerson1.setCurrentWeapon(weaponFist);
        monsterSet.getMonsters().add(monsterPerson1);

    }

    //开始游戏
    public void play() {
        System.out.println("-----------------------");
        ui.displayHelpMsg();
        ui.displayMap(this);
        ui.displayStaus(this);
        while (true)   {
            System.out.println("请输入你的指令：");
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            String[] words = command.split(" ");
            //分割命令行各个单元
            if(words[0].equals("attack")){
                //用户和程序之间的接口，建立一个get函数，输入字符串，返回一个monsterwolf对象
                ui.displayBattle(person,monsterSet.get(words[1]));
                ui.displayStaus(this);
            }else if (words[0].equals("go")) {
                ui.displayGo(this, words[1]);
            } else if (words[0].equals("pick")){
                ui.displayPick(this,words[1]);
            } else if (words[0].equals("open")){
                ui.displayKnapsack(this);
            } else if(words[0].equals("bye")){
                ui.displayBye();
            } else if (words[0].equals("help")){
                ui.displayHelpMsg();
            } else if(words[0].equals("map")){
                ui.displayMap(this);
            } else{
                ui.displayErrorCmdMsg();
            }
            ui.displayWinOrLose(this);
        }
    }
}
