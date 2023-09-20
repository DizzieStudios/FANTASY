
public class Hero extends Character
{
    private Items[] inventory;
    private Weapon[] weaponInventory;
    private boolean weaponsOnHand = false;
    private int n = 0;
    private Weapon equipped;
    private Attack att;
    private final int sides = 6;
    private Classes classes;
    private int currency;
    protected double stamina;
    private double maxStamina = 5;
    private Potion potion;
    public Hero(String name, int life, Classes classes)
    {
        super(name,life);
        att = new Attack(sides,this);
        this.classes = classes;
        stamina = 2.0;
        currency = 50;
    }

    public Hero(String name, int life)
    {
        super(name,life);
        att = new Attack(sides,this);
        classes = Classes.HERO;
        stamina = 2.0;
        currency = 50;
    }

    public void equip(int item){
        if ( n > 0 && inventory[item].isType(Type.WEAPON) ){
            if ( !weaponsOnHand ){
                equipped = (Weapon)inventory[item];
                removeFromInventory(item);
                weaponsOnHand = true;
            }else{
                addToInventory(equipped);
                equipped = (Weapon)inventory[item];
                removeFromInventory(item);
            }
        }
    }

    public void addToInventory(Items item){
        if( n == 0 ){
            inventory = new Items[1];
            inventory[0] = item;
            ++n;
        }else if ( n > 0 ){
            Items[] temp = new Items[n+1];
            for ( int i = 0; i < n ; i++ ){
                temp[i] = inventory[i];
            }
            temp[n] = item;
            inventory = temp;
            ++n;
        }
    }

    public void removeFromInventory(int c){
        if( n == 1 ){
            inventory = null;
            n = 0;
        }else if ( n > 1 ){
            Items[] temp = new Items[n-1];
            for ( int i = 0; i < c ; i++ ){
                temp[i] = inventory[i];
            }
            if( n-1 > c ){
                for ( int i = c+1; i < n ; i++ ){
                    temp[i-1] = inventory[i];
                }
            }
            inventory = temp;
            --n;
        }
    }

    public void useItemOrWeapon(int index){
        use(index);
        equip(index);
    }

    public void use( int index ){
        if ( inventory[index].isType(Type.POTION) ){
            potion = (Potion)inventory[index];
            potion.use();
            removeFromInventory(index);
        }
    }

    public Weapon getEquipped(){
        return equipped;
    }

    public Attack getAttack(){
        return att;
    }

    public Items[] getInventory(){
        return inventory;
    }

    public void listInventory(){
        if ( n == 0 ){
            System.out.println("Inventory empty");
        }else{
            System.out.println("Inventory:");
            for ( int i = 0 ; i < n ; i++ ){
                System.out.println(i+": "+inventory[i].getName());
            }
        }

    }

    public boolean hasWeapon(){
        return weaponsOnHand;
    }

    public Classes getClasses(){
        return classes;
    }

    public int getInventorySlots(){
        return n;
    }

    public void addStamina( double stamina ){
        if ( this.stamina + stamina <= maxStamina ){
            this.stamina += stamina;
        }else {
            this.stamina = maxStamina;
        }
    }

    public void reduceStamina( double stamina ){
        this.stamina -= stamina;
    }

    public boolean canReduceStamina( double stamina ){
        boolean can = false;
        if ( this.stamina - stamina >= 0 ) can = true;
        return can;
    }

    public boolean isWarior(){
        return classes == Classes.WARIOR;
    }

    public boolean isMage(){
        return classes == Classes.MAGE;
    }

    public int getCurrency(){
        return currency;
    }

    public void setCurrency(int currency){
        this.currency = currency;
    }

    public double getStamina(){
        return stamina;
    }
}
