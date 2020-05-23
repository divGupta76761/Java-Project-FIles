package PICalculator;

import PlotGraph.Plot;

import java.time.LocalDateTime;
import java.util.Scanner;

public class LeinBizSeries {
    LeinBizSeries(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of iterations:");
        int iterations = sc.nextInt();
        float pi = 4f;
        for(int i=0;i<iterations;i++){
            float den = (i*2)+3;
            if(i%2==0){
                pi -= 4/den;
            }else{
                pi+=4/den;
            }
        }
        System.out.println("PI = "+pi);
        System.out.println("Correct PI = "+Math.PI);
    }
    public static void main(String[]args){new LeinBizSeries();}
}
