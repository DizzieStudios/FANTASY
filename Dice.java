
import java.util.Random;
public class Dice
{
    private int sides;
    private Random dice;
    public Dice(int sides)
    {
        this.sides = sides;
        dice = new Random();
    }
    
    public int roll(){
        return dice.nextInt(sides)+1;
    }
    
}
