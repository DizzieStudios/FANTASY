import sas.*;

public class SCENE
{
    Shapes[] shapes;
    View v;
    GUI gui;
    public SCENE(Shapes[] shapes, GUI gui)
    {
        this.shapes = shapes;
        this.gui = gui;
    }

    public void setHidden( boolean hidden ){
        for ( Shapes s : shapes ){
            s.setHidden(hidden);
        }
    }
    
    protected void setShapes(Shapes[] shapes){
        this.shapes = shapes;
    }
    
    public boolean[] getAction(){
        boolean[] b = new boolean[shapes.length];
        for ( int i = 0 ; i < shapes.length ; i++ ){
            b[i] = shapes[i].mousePressed();
        }
        return b;
    }
    
}
