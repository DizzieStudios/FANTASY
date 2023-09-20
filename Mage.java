
public class Mage extends Hero
{
    
    public Mage(String name, int life)
    {
        super(name, life, Classes.MAGE);
    }
    
    public void healCompletely(){
        super.addLife(super.getMaxLife()-super.getLife());
    }
    
}
