

public class Random_Item
{
    private static final int types = 2;
    private static final int weaponTypes = 2;
    private static final int potionTypes = 2;
    private static final int materials = 3;
    public static Items randomItem(Hero hero){
        Items item = null;
        Dice dtypes = new Dice(types+2);
        if ( dtypes.roll() == 1 ){
            Dice dweapontypes = new Dice(weaponTypes);
            if ( dweapontypes.roll() == 1 ){
                Dice matd = new Dice(materials);
                if(matd.roll() == 1 ){
                    item = new Sword(Materials.copper);
                }else if ( matd.roll() == 2 ){
                    item = new Sword(Materials.iron);
                }else{
                    item = new Sword(Materials.gold);
                }
            }else{
                Dice matd = new Dice(3);
                if(matd.roll() == 1 ){
                    item = new Dagger(Materials.copper);
                }else if ( matd.roll() == 2 ){
                    item = new Dagger(Materials.iron);
                }else{
                    item = new Dagger(Materials.gold);
                }
            }
        }else{
            Dice pt = new Dice(potionTypes);
            if ( pt.roll() == 1 ){
                item = new Stamina_Potion(hero);
            }else {
                item = new Healing_Potion(hero);
            }
        }
        return item;
    }
}
