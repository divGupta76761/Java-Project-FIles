// java program to draw a ellipse
// using drawOval function.
import java.awt.*;
import javax.swing.*;

public class Game extends JApplet {
    public static void main(String[] args){

    }
    public  void init()
    {
        // set size
        setSize(400, 400);

        repaint();
    }

    // paint the applet
    public void paint(Graphics g)
    {
        // set Color for rectangle
        g.setColor(Color.red);

        // draw a ellipse
        g.drawOval(100, 100, 150, 100);
    }
}


