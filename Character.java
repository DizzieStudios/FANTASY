
public class Character
{
    private double attack;
    private int life;
    private String name;
    private int maxLife;
    public Character(String name, int life)
    {
        this.name = name;
        this.life = life;
        maxLife = life;
    }
    
    public String getName(){
        return name;
    }
    
    public int getLife(){
        return life;
    }
    
    public void reduceLife(int life){
        this.life -= life;
    }
    
    public int getMaxLife(){
        return maxLife;
    }
    
    public void addLife(int life){
        if ( this.life + life <= maxLife ){
            this.life += life;
        }else {
            this.life = maxLife;
        }
    }
    
    public void addMaxLife(int maxLife){
        this.maxLife = maxLife;
    }
}
