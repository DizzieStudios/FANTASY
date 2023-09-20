

public class Stamina_Potion extends Potion
{
    private final double stamina = 1;
    private Hero hero;
    public Stamina_Potion(Hero hero)
    {
        super();
        this.hero = hero;
        super.setWorth(5);
        super.setName("Stamina Potion");
    }
    
    public void use(){
        hero.addStamina(stamina);
    }
}
