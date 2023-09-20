

public class Items
{
    private Type type;
    private String name;
    private int worth;
    public Items(Type type)
    {
        this.type = type;
    }
    
    public Type getType(){
        return type;
    }
    
    public String getName(){
        return name;
    }
    
    protected void setWorth(int worth){
        this.worth = worth;
    }
    
    protected void setName(String name){
        this.name = name;
    }
    
    public int getWorth(){
        return worth;
    }
    
    public boolean isType( Type type ){
        boolean isType = false;
        if ( this.type == type ){
            isType = true;
        }
        return isType;
    }
    
    
}
