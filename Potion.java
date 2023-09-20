

public abstract class Potion extends Items
{
    private String potionType;
    public Potion()
    {
        super(Type.POTION);
    }

    abstract void use();    
}
