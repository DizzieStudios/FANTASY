import sas.*;

public class GUI
{
    View view;
    public GUI(){
        view = new View(800,800);
    }
    void changeScene(SCENE in, SCENE out){
        in.setHidden(true);
        out.setHidden(false);
    }
}
