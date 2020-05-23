package Coder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ConvertToCode {
    char[]letters;
    ConvertToCode(){
        letters = new char[26];
        char j = 'a';
        for(int i=0;i<letters.length;i++){
            letters[i] = j;
            //System.out.println(letters[i]);
            j++;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your code");
        String input = sc.nextLine();
        input = input.toLowerCase();
        char[]inputLetters = input.toCharArray();
        char pre = ' ';
        for(int l=0;l<inputLetters.length;l++){
            char cur = inputLetters[l];
            if(cur==pre){
                inputLetters[l] = ';';
                inputLetters[l-1] = ';';
            }
            pre = cur;
        }
        for(int q=0;q<inputLetters.length;q++){
            if(inputLetters[q]!=';'){
                System.out.print(inputLetters[q]);
            }
        }
    }
    public static void main(String[]args){
        new ConvertToCode();
    }
}
