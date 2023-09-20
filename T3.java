import sas.*;
import java.awt.Color;
public class T3
{
    View v;
    Shapes r[] = new Rectangle[100];
    public T3()
    {
        int k = 0;
        v = new View(1000,1000);
        for ( int i = 0; i < 10 ; i++ ){
            for ( int j = 0 ; j < 10 ; j++ ){
                r[k] = new Rectangle( j*100, i*100, 100, 100);
                ++k;
            }
        }
        while (true){
            for ( Shapes ra : r){
                if ( ra.mousePressed() ){
                    ra.setColor(Color.WHITE);
                }
            }
        }
    }

    
}
