

public class Dagger extends Weapon
{
    private String name;
    private double bonus;
    public Dagger(Material m)
    {
       super(m); 
       name = m.getName()+" Dagger";
       bonus = ((double)m.getStrength())*(0.75);
       super.setName(name);
       super.setBonus(bonus);
       super.setWorth(5*m.getStrength());
    }

    
}
