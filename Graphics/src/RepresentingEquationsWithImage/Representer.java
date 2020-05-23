package RepresentingEquationsWithImage;

import Physics.RangeOfProjectile;
import PlotGraph.Plot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Representer extends JFrame {
    BufferedImage image;
    //Color[]pixelColours;
    Representer(){
        Plot plot = new Plot("Equations",700,.01f,.01f,200);
        //ImageSetup
        image = new BufferedImage(600,600,BufferedImage.TYPE_INT_RGB);
        //pixelColours = new Color[image.getWidth()*image.getHeight()];
        for(int i=0,index=0;i<image.getWidth();i++){
            for(int j=0;j<image.getHeight();j++){
                //float k = (float) (Math.sin(i)*Math.cos(j)*Math.cos(i)*Math.sin(j)*Math.tan(i)*Math.tan(j));
                int sample = (int) Math.pow((i+j),1);
                //int sample = wave(index,4,(i+j));
                plot.addPoint(index,sample);
                image.setRGB(i,j,sample);
                index++;
            }
        }
        plot.showPlot();
        //SavingSetup
        JPanel panel = new JPanel();
        Button save = new Button("Save");
        panel.add(save);
        this.add(panel);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = "image.png";
                System.out.println("Saving");
                File imageFile = new File("C:\\Users\\divya\\Desktop\\IMages\\"+fileName);
                if(imageFile.exists()){
                    fileName = "image"+new Random().nextInt(10000000)+".png";
                    imageFile = new File("C:\\Users\\divya\\Desktop\\IMages\\"+fileName);
                }
                try {
                    ImageIO.write(image,"png",imageFile);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //Frame setup
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(3);
        setVisible(true);
    }
    public static void main(String[]args) throws IOException {
        Representer representer = new Representer();
        representer.repaint();
    }
    @Override
    public void paint(Graphics g){
        g.drawImage(image,0,0,600,600,null);
    }
    int wave(int x,int iterations,float scale){
        float y=0;
        for(int i=1;i<iterations;i+=2){

            float toAdd = (float) (Math.sin(x*i)/i);
            y+=toAdd;
            y*=scale;

        }

        return (int) y;
    }

}
