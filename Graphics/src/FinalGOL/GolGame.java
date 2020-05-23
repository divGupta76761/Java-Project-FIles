package FinalGOL;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ImageObserver;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GolGame extends JFrame {
    int initialLiveCells = 60000;
    JTextField genField;
    int gen=0;
    BufferedImage image;
    int[][]grid;
    int frameSize = 600;
    int zoom = 1;
    GolGame(){
        genField = new JTextField();
        genField.setEditable(false);
        genField.setPreferredSize(new Dimension(100,30));
        genField.setFont(new Font("Arial", Font.PLAIN,25));
        JPanel panel = new JPanel();
        panel.add(genField);
        //Image
        image = new BufferedImage(frameSize/zoom,frameSize/zoom,BufferedImage.TYPE_INT_RGB);
        //Frame
        setSize(frameSize+40,frameSize+60);
        add(panel);
        setLayout(new GridLayout(1,1));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(3);
        setBackground(new Color(0, 0, 0, 255));
        setVisible(true);
    }
    public static void main(String []args){GolGame gol = new GolGame();gol.start(gol);}
    @Override
    public void paint(Graphics g){
        g.clearRect(0,0,getWidth(),getHeight());
        g.translate(20,35);
        for(int i=0;i<image.getWidth();i++){
            for(int j=0;j<image.getHeight();j++){
                if(grid[i][j]==0){
                    image.setRGB(i,j,Color.WHITE.getRGB());
                }else{
                    image.setRGB(i,j, Color.BLACK.getRGB());
                }
            }
        }

        g.drawImage(image,0,0,frameSize,frameSize,null);
    }
    public  void start(GolGame gol){
        Random r = new Random();
        gol.grid = new int[gol.image.getWidth()][gol.image.getHeight()];
        for(int i=0;i<gol.image.getWidth();i++){
            for(int j=0;j<gol.image.getHeight();j++){
                grid[i][j]=0;
                grid[i][j] = r.nextInt(2);
            }
        }
        /*for(int j=0;j<initialLiveCells;j++){
            int x = r.nextInt(grid.length);
            int y= r.nextInt(grid[0].length);

            int index = r.nextInt(2);
            if(index==0){
                grid[x][y] = 1;
            }else if(index==1){
                int x1 = x+1;
                int x2 = x+2;

            if(x1<grid.length&&x2<grid.length) {
                grid[x][y] = 1;
                grid[x1][y] = 1;
                grid[x2][y] = 1;
                j++;
                j++;
            }
            }*/
            //Draw vertical lines


        //Pulsar
        /*gol.grid[10][10]=1;gol.grid[10][11]=1;gol.grid[10][12]=1;
        gol.grid[12][8]=1;gol.grid[13][8]=1;gol.grid[14][8]=1;
        gol.grid[15][10]=1;gol.grid[15][11]=1;gol.grid[15][12]=1;
        gol.grid[14][13]=1;gol.grid[13][13]=1;gol.grid[12][13]=1;
        gol.grid[15+2][10]=1;gol.grid[15+2][11]=1;gol.grid[15+2][12]=1;
        gol.grid[18][8]=1;gol.grid[19][8]=1;gol.grid[20][8]=1;
        gol.grid[10+12][10]=1;gol.grid[10+12][11]=1;gol.grid[10+12][12]=1;
        gol.grid[18][13]=1;gol.grid[19][13]=1;gol.grid[20][13]=1;
        gol.grid[14][15]=1;gol.grid[13][15]=1;gol.grid[12][15]=1;
        gol.grid[15][16]=1;gol.grid[15][17]=1;gol.grid[15][18]=1;
        gol.grid[12][8+12]=1;gol.grid[13][8+12]=1;gol.grid[14][8+12]=1;
        gol.grid[10][16]=1;gol.grid[10][17]=1;gol.grid[10][18]=1;
        gol.grid[20][15]=1;gol.grid[19][15]=1;gol.grid[18][15]=1;
        gol.grid[17][16]=1;gol.grid[17][17]=1;gol.grid[17][18]=1;
        gol.grid[18][8+12]=1;gol.grid[19][8+12]=1;gol.grid[20][8+12]=1;
        gol.grid[22][16]=1;gol.grid[22][17]=1;gol.grid[22][18]=1;*/
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
            gen++;
            gol.Update(gol);
            genField.setText(Integer.toString(gen));
            try{
                TimeUnit.MILLISECONDS.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
    public void Update(GolGame gol){
        int[][]next = new int[gol.image.getWidth()][gol.image.getHeight()];
        for(int i=0;i<gol.image.getWidth();i++){
            for(int j=0;j<gol.image.getHeight();j++){
                //if(i>0&&j>0&&i<gol.image.getWidth()-1&&j<gol.image.getHeight()-1){
                int state = gol.grid[i][j];
                int neighbour = neigh(gol.grid,i,j);

                if(state==0&&neighbour==3){
                    next[i][j]=1;
                }else if(state==1&&(neighbour<2||neighbour>3)){
                    next[i][j]  =0;
                }else{
                    next[i][j]=state;
                }
                //}
            }
        }
        gol.grid = next;
        gol.repaint();
    }

    int neigh(int[][]g,int x,int y){
        int q=g.length;
        int w = g[0].length;
        int sum=0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                //int col = (x+i);
                //int row = (y+j);
                int col = (x+i+q)%q; // Warp Code
                int row = (y+j+w)%w;
                //Exclude Edges
                //if(col>=0&&row>=0&&col<q&&row<w){
                sum+=g[col][row];

                //}
            }
        }
        sum -= g[x][y];
        return  sum;
    }
}

