@Deprecated
public class Timefreeze extends Ability
{
    private boolean active = false;
    private int level;
    private int turn;
    private final int duration = 1;
    private Monster monster;
    public Timefreeze(Hero hero)
    {
        super(1,2.0,hero);
    }

    public void cast(int turn, Monster monster){
        if( super.getHero().canReduceStamina(super.getCost()) ){
            super.use();
            this.monster = monster;
            level = monster.level;
            monster.getAttack().setLevel(0);
            active = true;
            this.turn = turn;
        }
    }
    
    public void checkDuration( int turn ){
        if ( turn - duration == this.turn && active){
            monster.getAttack().setLevel(level);
            active = false;
        }
    }
}
