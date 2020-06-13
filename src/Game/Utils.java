package Game;

public class Utils {
    //产生 min 到 max-1的随机数 0：不砍 1：砍
    private static int min = 0;
    private static int max = 2;
    public static int randomMonsterChop(){
        return (int) (Math.random()*(max-min)+min);
    }
}