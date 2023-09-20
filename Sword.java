
public class Sword extends Weapon
{
    private String name;
    private double bonus;
    public Sword(Material m)
    {
        super(m); 
       name = m.getName()+" Sword";
       bonus = m.getStrength();
       super.setName(name);
       super.setBonus(bonus);
       super.setWorth(7*m.getStrength());
    }

    
}
