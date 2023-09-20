@Deprecated
public class Hack_And_Slash extends Ability
{
    private Monster monster;
    public Hack_And_Slash(Hero hero)
    {
        super(3,1.0,hero);
    }

    public void cast(Monster monster){
        if( super.getHero().canReduceStamina(super.getCost()) ){
            super.use();
            this.monster = monster;
            monster.reduceLife(super.getStrength());
        }
    }

}
