package Test;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

public class Testing {
    public static void main(String[]args){
        System.out.println("Enter your code:");
        Scanner sc = new Scanner(System.in);
        String code = null;
        code = sc.nextLine();
        Compile(code);

    }
    public static void Compile(String code){
        String[]commands = {"print"};
        char[]rawLetters = code.toCharArray();
        char[]letters = new char[rawLetters.length];

        for(int i=0;i<rawLetters.length;i++){

               letters[i] = rawLetters[i];
        }
        int lettersInLine =0;
        for(int i=0;i<letters.length;i++){
            if(letters[i]!=';'){
                if(letters[i]!=' '){
                    lettersInLine++;
                }
            }
        }
        char[]lineLetters = new char[lettersInLine];

        for(int i=0;i<lineLetters.length;i++){

                lineLetters[i]=letters[i];



        }
        Object[]objects=new Object[1];

        for(int i=0;i<lineLetters.length;i++){
            if(lineLetters[i]=='('){
                char[]toPrint = new char[lineLetters.length-(i+1)];
            if(i+1!=lineLetters.length){

                for(int j=0;j<lineLetters.length-(i+1);j++){
                    toPrint[j]=lineLetters[j+(i+1)];

                }
            }
            for(int l=0;l<objects.length;l++){
                objects[l] = new String(toPrint);
            }
        }}
        String line = new String(lineLetters);
        System.out.println(commands[0].compareTo(line));
        for(int i=0;i<commands.length;i++){
            if(commands[0].compareTo(line)==0){
                System.out.println("Execute");
                if(i==0){
                    System.out.println(i);
                    Print(objects[i]);
                }
            }
        }
    }
    public static void Print(Object object){
        System.out.println(object);
    }


}
