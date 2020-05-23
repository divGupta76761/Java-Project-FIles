package Physics;
import PlotGraph.Plot;

import java.util.Random;

public class RangeOfProjectile {
    Plot plot;

    RangeOfProjectile(){
        plot = new Plot("Physics",600,1,1,200);
        for(int i=0,j=50;i<50;i++){
            int range = CalRange(j,i);
            plot.addPoint(i,range);
            j--;
        }
    }
    double wave(double x){
        double y = Math.sin(x)+Math.sin(3*x)/3;
        return y;
    }
    public static void main(String[]args){
        new RangeOfProjectile();
    }

    int CalRange(double speed,double angleInDegrees){
        double g,angleInRads,range;
        g = 9.8;
        int r =0;
        angleInRads = angleInDegrees+Math.PI/180;
        range = 2*speed*speed*Math.sin(angleInRads)*Math.cos(angleInRads)/g;
        r = (int) Math.round(range);
        return r;
    }
}
