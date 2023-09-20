import java.util.Scanner;
public class Console_Interface extends UI
{
    Scanner input;
    Shop shop;
    Hero hero;
    Monster monster;
    Battle battle;
    public Console_Interface()
    {
        input = new Scanner(System.in);
        monster = new Kijin(1);
        setUp();
    }

    public void openInventory(){
        hero.listInventory();
        m:
        while ( true ){
            if ( hero.getInventorySlots() == 0 ) break m;
            System.out.println("Enter the number of the item you want use or 'esc' to exit");
            String in = input.next();
            if ( in.equals("esc") ){
                break m;
            }
            try{
                if( Integer.parseInt(in) < hero.getInventorySlots()){
                    hero.useItemOrWeapon(Integer.parseInt(in));
                    hero.listInventory();
                    continue m;
                }
            }catch(Exception e){}
        }
        System.out.println();
    }

    public void showAbilities(){
        if ( hero.isMage() ){ System.out.println("0: Heal");}
        else{
            System.out.println("No skills available");
        }
        m:
        while (true){
            if ( !hero.isMage() ) break m;
            String in = input.next();
            if ( in.equals("esc") ){
                break m;
            }
            if ( in.equals("0") && hero.isMage() ){
                Mage mage = (Mage)hero;
                mage.healCompletely();
                break m;
            }
        }
        System.out.println();
    }

    public void attack(){
        System.out.println(battle.turn()+" attacks" );
        System.out.println();
    }

    public void openShop(){
        shop.open();
        shop.listStock();
        m:
        while ( true ){
            System.out.println("Enter either the number of the product you want to buy or 'esc' to exit");
            String in  = input.next();
            if ( in.equals("esc") ){
                break m;
            }
            try{
                if ( Integer.parseInt(in) < shop.getStock().length ){
                    try{
                        shop.buy(Integer.parseInt(in));
                        shop.open();
                        shop.listStock();
                    }catch( InsufficientCurrencyException iCE ){
                        System.out.println(iCE.getMessage());
                        shop.open();
                        shop.listStock();
                    }
                    continue m;
                }
            }catch(Exception e){}
        }
        System.out.println();
    }

    public void exe(){

        while ( hero.getLife() > 0 ){
            if ( battle.isOver() && hero.getLife() > 0 ){
                System.out.println(hero.getName()+" WON!");
                monster = new Kijin(10);
                battle = new Battle(hero,monster,this);
            }
            System.out.println("Type 'attack','shop','inventory','abilities' for the coresponding function.");
            System.out.println("Your life: "+hero.getLife()+"/"+hero.getMaxLife());
            System.out.println("Your stamina: "+hero.getStamina());
            System.out.println("Enemy life: "+monster.getLife());
            String in = input.next();
            if( in.equals("attack") ){
                attack();
            }
            if( in.equals("shop") ){
                openShop();
            }
            if( in.equals("inventory") ){
                openInventory();
            }
            if( in.equals("abilities") ){
                showAbilities();
            }
            if( in.equals("exit") ) System.exit(0);
        }
        while ( true ){
            System.out.println("Game Over. Restart? Y/N");
            String in = input.next();
            if ( in.equals("Y") ) setUp();
            if ( in.equals("N") ) System.exit(0);
        }

    }

    public void setUp(){
        first:
        while( true ){
            System.out.println("Choose your class: MAGE,WARIOR,HERO");
            String in = input.next();
            if ( in.equals("MAGE") ){
                while ( true ){
                    System.out.println("Enter name:");
                    in = input.next();
                    hero = new Mage(in,10);
                    break first;
                }
            }
            if ( in.equals("WARIOR") ){
                while ( true ){
                    System.out.println("Enter name:");
                    in = input.next();
                    hero = new Warior(in,10);
                    break first;
                }
            }
            if ( in.equals("HERO") ){
                while ( true ){
                    System.out.println("Enter name:");
                    in = input.next();
                    hero = new Hero(in,10);
                    break first;
                }
            }
        }
        monster = Random_Monster.getRandomMonster();
        battle = new Battle(hero, monster, this);
        shop = new Shop(hero);
        exe();
    }
}
