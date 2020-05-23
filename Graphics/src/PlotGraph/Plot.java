package PlotGraph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plot extends JFrame {
    int pointIndex = 0;
    int i=0;
    List<Integer> xPoints;
    List<Integer>yPoints;
    int frameSize;
    float yScale;
    float xScale;
    int offsetY = 0;
    public Plot(String title,int frameSize,float xScale,float yScale,int offsetY){
        xPoints = new ArrayList<Integer>();
        yPoints = new ArrayList<Integer>();
        setSize(frameSize,frameSize);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.frameSize = frameSize;
        this.xScale = xScale;
        this.yScale = yScale;
        this.offsetY = offsetY;
    }
    public void addPoint(int x,int y){
        xPoints.add(pointIndex,x);
        yPoints.add(pointIndex,y);
        pointIndex++;
    }

    public void showPlot(){
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        //g.drawRect(20,35,20,20);

        g.setColor(Color.BLACK);
        g.translate(30,getHeight()-offsetY);
        g.drawLine(0,0,frameSize,0);
        g.drawLine(0,0,0,-frameSize);
        int preXpoint = 0;
        int preYpoint = 0;
        for (int i=0;i<xPoints.size();i++){

            int xPoint = (int) (xPoints.get(i)*xScale*1);
            int yPoint = (int) (yPoints.get(i)*yScale*-1);


            g.drawLine(preXpoint,preYpoint,xPoint,yPoint);
            //g.fillOval(preXpoint,preYpoint,5,5);
            preXpoint = xPoint;
            preYpoint = yPoint;
        }

    }

}
