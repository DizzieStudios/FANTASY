

public class Material
{
    private int strength;
    private String name;
    public Material(int strength,String name)
    {
        this.strength = strength;
        this.name = name;
    }

    public int getStrength(){
        return strength;
    }
    
    public String getName(){
        return name;
    }
}
