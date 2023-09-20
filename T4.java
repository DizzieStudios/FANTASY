import sas.*;

public class T4 extends SCENE 
{
    static Shapes[] shapes = {new Rectangle(0,0,100,100),new Circle(200,200,50)};
    public T4(GUI gui){
        super(shapes,gui);
    }
}
