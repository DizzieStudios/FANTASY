

public class Healing_Potion extends Potion
{
    private final int life = 5;
    private Hero hero;
    public Healing_Potion(Hero hero)
    {
        super();
        this.hero = hero;
        super.setWorth(5);
        super.setName("Healing Potion");
    }
    
    public void use(){
        hero.addLife(life);
    }
}
