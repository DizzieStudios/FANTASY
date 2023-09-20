/**
 * A class that is used to generate an attack-value for a character
 * @author Dizzie
 * @version 1.1
 */
public class Attack
{
    private double attack;
    private boolean hero;
    private double bonus;
    private boolean hasWeapon;
    private Dice d;
    private int level;
    private boolean warior;
    private Hero h;
    private double stamina;
    private boolean bypassed = false;

    /**
     * Create an Attack-object for a monster
     * @param level level of the monster
     * @param dice number of possible randomly generated natural numbers(between 1 and dice) for the attack
     */
    public Attack(int level,int dice)
    {
        hero = false;
        d = new Dice(dice);
        this.level = level;
    }

    public Attack(int dice, Hero h){
        hero = true;
        this.warior = warior;
        this.h = h;
        d = new Dice(dice);
    }

    /**
     * Set the level of the monster.
     * @param level level of the monster
     */
    public void setLevel(int level){
        this.level = level;
    }

    /**
     *  Calculates the attack-value for the given Character-object
     */
    private void calculateAttack(){
        if ( hero ){
            hasWeapon = h.hasWeapon();
            if( hasWeapon ){
                bonus = h.getEquipped().getBonus();
            }
            if ( warior ){
                stamina = h.getStamina();
            }
        }

        if ( warior && !hasWeapon ){
            attack = d.roll()*stamina;
        }else if ( warior && hasWeapon ){
            attack = ((double)d.roll()+((double)bonus/2))*stamina;
        }else if ( hero && !hasWeapon ){
            attack = d.roll();
        } else if ( hero && hasWeapon ){
            attack = d.roll()+bonus;
        } else if ( !hero ){
            attack = (double)d.roll()*(0.5*(level-1));
        }
    }

    /**
     *
     * @return calculated attack-value for the given Character-Object
     */
    public double getAttack(){
        calculateAttack();
        return attack;
    }
}
