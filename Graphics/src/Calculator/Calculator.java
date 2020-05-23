package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame{
    Calculator(){
        //Number field
        JTextField numberInput = new JTextField();
        numberInput.setPreferredSize(new Dimension(300,50));
        numberInput.setFont(new Font("Arial",Font.PLAIN,45));
        numberInput.setEditable(false);
        //Panel setup
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4,4,10,10));
        //button setup
        JButton[]jButtons = new JButton[12];
        for(int i=0;i<jButtons.length;i++){
            jButtons[i] = new JButton(Integer.toString(i));
            //jButtons[i].setSize(40,70);
            //jButtons[i].setPreferredSize(new Dimension(40,70));
            jButtons[i].setFont(new Font("Arial",Font.PLAIN,35));
            int finalI = i;
            if(i<10){
            jButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //System.out.println(finalI1+1);
                    numberInput.setText(numberInput.getText()+jButtons[finalI].getText());
                }
            });}
            mainPanel.add(jButtons[i]);
        }
        //mainPanel.add(numberInput);
        this.add(numberInput);
        setLayout(new GridLayout(2,1));
        //Frame setup
        setSize(600,600);
        //pack();
        setDefaultCloseOperation(3);
        this.add(mainPanel);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[]args){
        new Calculator();
    }
}
