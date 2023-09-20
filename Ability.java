@Deprecated
public class Ability
{
    private int strength;
    private double cost;
    private Hero hero;
    public Ability(int strength, double cost, Hero user)
    {
        this.strength = strength;
        this.cost = cost;
        hero = user;
    }
    
    public Hero getHero(){
        return hero;
    }
    
    protected void use(){
        hero.reduceStamina(cost);
    }
    
    public double getCost(){
        return cost;
    }
    
    public int getStrength(){
        return strength;
    }

}
