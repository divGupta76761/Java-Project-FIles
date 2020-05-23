package Test;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.util.Random;

public class GameOfLife extends JFrame {
    int width = 6;

int [][]newState;
int [][]temporary;
    GameOfLife(){
        setSize(600,600);
        setTitle("Game Of Life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        //setExtendedState(MAXIMIZED_BOTH);

        setVisible(true);
    }
    public static void main(String[]args)
    {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.repaint();

    }
    @Override
    public void paint(Graphics g){
        Random rand  =new Random();
        int q=0;
        int w=0;
        for(q=0;q<getSize().width;q++){
            for(w=0;w<getSize().height;w++){

            }
        }
        newState = new int[q][w];
        temporary=new int[q][w];

        for(int x=0;x<getSize().width;x+=width){
            for(int y=0;y<getSize().height;y+=width){
                g.setColor(Color.BLACK);
                g.drawRect(x,y,width,width);
                g.fillRect(x,y,width,width);
                int should = rand.nextInt(3);
                if(should==1){
                    newState[x][y] = rand.nextInt(2);
                    if(newState[x][y]==1){
                        g.setColor(Color.white);
                        g.fillRect(x,y,width,width);
                    }else{
                        g.setColor(Color.BLACK);
                        g.fillRect(x,y,width,width);
                    }
                }

            }
        }
        update(g);
    }
    @Override
    public void update(Graphics g){
        temporary=newState;
        for(int x=0;x<temporary.length;x++){
            for(int y=0;y<temporary[x].length;y++)
            {
                int living=0;
                int neighbourX=0;
                int neighbourY=0;
                for(int i=-1;i<2;i++){
                    for(int q=-1;q<2;q++){
                        neighbourX=x;
                        neighbourY=y;
                        neighbourX+=i;
                        neighbourY+=q;
                        for(int l=0;l<temporary.length;l++){
                            for(int e=0;e<temporary[l].length;e++){
                                if(l==neighbourX&&e==neighbourY){
                                    if(temporary[l][e]==1){
                                        living++;
                                    }
                                }
                            }
                        }
                    }
                }
                if(living<=2){
                    g.setColor(Color.BLACK);
                    g.fillRect(x,y,width,width);
                }else if(living==3){
                    g.setColor(Color.white);
                    g.fillRect(x,y,width,width);
                }else if(living>3){
                    g.setColor(Color.BLACK);
                    g.fillRect(x,y,width,width);

                }
            }
        }
        newState=temporary;
        for(int x=0;x<newState.length;x++){
            for(int y=0;y<newState[x].length;y++){
                if(newState[x][y]==1){
                    g.setColor(Color.white);
                    g.fillRect(x,y,width,width);
                }else{
                    g.setColor(Color.BLACK);
                    g.fillRect(x,y,width,width);
                }
            }
        }
    }


}
