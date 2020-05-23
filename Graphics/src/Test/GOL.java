package Test;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GOL extends JFrame {
    int[][] grid;
    int col;
    int rows;
    int resolution = 20;
    int frameDimension = 600;

    GOL() {
        setSize(frameDimension, frameDimension);
        setTitle("Game Of Life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        //setExtendedState(MAXIMIZED_BOTH);

        setVisible(true);

    }

    public static void main(String[] args) {
        GOL goL = new GOL();
        goL.repaint();
    }

    @Override
    public void paint(Graphics g) {
        rows = frameDimension / resolution;
        col = frameDimension / resolution;
        grid = new int[rows][col];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int x = i * resolution;
                int y = j * resolution;
                grid[i][j] = new Random().nextInt(2);
                if (grid[i][j] == 1) {
                    g.setColor(Color.WHITE);
                    g.fillRect(x, y, resolution - 1, resolution - 1);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, resolution, resolution);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, resolution - 1, resolution - 1);
                    g.setColor(Color.WHITE);
                    g.drawRect(x, y, resolution, resolution);
                }
            }
        }

            update(g);

    }
    @Override
    public void update(Graphics g) {

            int[][]next = grid;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int living = countNeighbour(i,j);
                    if(living<=2){
                        next[i][j]=0;
                    }else if(living==3){
                        next[i][j]=1;
                    }else if(living>3){
                        next[i][j]=0;
                    }
                }
            }
            g.clearRect(0,0,frameDimension,frameDimension);
            for(int i=0;i<next.length;i++){
                for(int j=0;j<next[i].length;j++){
                    grid[i][j] = next[i][j];
                    int x= i*resolution;
                    int y=j*resolution;
                    if(next[i][j]==1){
                        g.setColor(Color.WHITE);
                        g.fillRect(x,y,resolution-1,resolution-1);
                        g.setColor(Color.BLACK);
                    }else{
                        g.setColor(Color.BLACK);
                        g.fillRect(x,y,resolution-1,resolution-1);
                        g.setColor(Color.WHITE);
                    }
                    g.drawRect(x,y,resolution,resolution);
                }
            }
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }



    public int countNeighbour(int i, int j){
        int living=0;
        for (int l = -1; l < 2; l++) {
            for (int q = -1; q < 2; q++) {
                int neighX = i + l;
                int neighY = j + q;
                if(neighX>=0&&neighY>=0&&neighX<rows&&neighY<col){
                    if(grid[neighX][neighY]==1){
                        living++;
                    }
                }
            }
        }
        return living;
    }
}
