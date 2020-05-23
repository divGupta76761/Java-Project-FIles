package FourierSeries;

import PlotGraph.Plot;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Series extends JFrame {
    int index=0;
    static Plot plotter;
    float time = 0f;
    Series(){
        plotter = new Plot("Series",800,1,1,500);
        setSize(600,600);
        setDefaultCloseOperation(3);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[]args) throws InterruptedException {
       Series series =  new Series();
        int i=0;
       while (i<1000) {
           series.repaint();
           TimeUnit.MILLISECONDS.sleep(70);
           i++;
       }
       plotter.showPlot();
    }
    @Override
    public void paint(Graphics g){
        g.clearRect(0,0,getWidth(),getHeight());
        int radius = 0;
        g.translate(200,200);
        //g.drawOval(0,0,radius*2,radius*2);
        int x=0;
        int y=0;
        for(int p=1;p<6;p+=2){
            radius = (int) (100*(4/(p*Math.PI)));
        x += (int) (radius*Math.cos(time*p));
        y += (int)(Math.sin(time*p)*radius);
        int pX = -x;
        int pY = -y;
        int centreX = (x+pX)/2;
        int centreY = (y+pY)/2;
        //g.setColor(Color.RED);
        //g.fillOval(centreX,centreY,30,30);
        g.setColor(Color.BLACK);
        g.fillOval(x,y,10,10);
        int offsetX = 5;
        int offsetY = 5;
        g.drawOval(centreX-radius+offsetX,centreY-radius+offsetY,radius*2,radius*2);
        time+=0.05f;
        plotter.addPoint(index,y);
        index++;
    }}

}

