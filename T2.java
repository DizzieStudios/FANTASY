import sas.*;

public class T2
{
    public T2(){
        GUI gui = new GUI();
        SCENE s = new T4(gui);
        while ( true ){
            s.setHidden(true);
            gui.view.wait(1000);
            s.setHidden(false);
            gui.view.wait(1000);
        }
    }
}
