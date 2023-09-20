import sas.*;

public class Slime extends Monster
{
    
    public Slime(int level)
    {
        super("Slime",1,level);
    }

    public Picture getPicture(){
        return new Picture(300,50,250,250,"rimuru_slime.png");
    }
}
