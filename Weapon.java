

public class Weapon extends Items
{
    private double bonus;
    private String name;
    public Weapon(Material m)
    {
        super(Type.WEAPON);
    }
    
    public double getBonus(){
        return bonus;
    }
    
    protected void setBonus(double bonus){
        this.bonus = bonus;
    }

    /**
     *
     * @param name
     */
    @Override
    protected void setName(String name){
        this.name = name;
        super.setName(name);
    }
    
    
}
