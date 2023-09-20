

public class Random_Monster
{
    public static Monster getRandomMonster(){
        Monster monster = null;
        Dice d = new Dice(2);
        if ( d.roll() == 1 ){
            monster = new Slime(2);
        }else{
            monster = new Kijin(2);
        }
        return monster;
    }
}
