
public class Battle
{
    private Hero hero;
    private Monster monster;
    private UI ui;
    private int turn;
    public Battle(Hero hero, Monster monster, UI ui)
    {
        this.hero = hero;
        this.monster = monster;
        this.ui = ui;
        turn = 0;
    }
    
    public String turn(){
        String w = "";
        if ( !isOver() ){
            if ( hero.getAttack().getAttack() > monster.getAttack().getAttack() ){
                monster.reduceLife(1);
                w = hero.getName();
            }else{
                hero.reduceLife(1);
                w = monster.getName();
            }
            turn += 1;
        }
        return w;
    }

    public void playTurn(){
        if ( !isOver() ){
            if ( hero.getAttack().getAttack() > monster.getAttack().getAttack() ){
                monster.reduceLife(1);
            }else{
                hero.reduceLife(1);
            }
            turn += 1;
        }
    }
    
    public boolean isOver(){
        boolean over;
        if ( hero.getLife() <= 0 || monster.getLife() <= 0 ){
            over = true;
        }else {
            over = false;
        }
        if ( over && hero.getLife() > 0 ){
            hero.addToInventory(Random_Item.randomItem(hero));
            hero.setCurrency(hero.getCurrency()+10);
        }
        return over;
    }

}
