import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	String answer= new String(sc.next());
    	char tmp;
    	for(int i = 0 ;i<answer.length();i++) {
    		tmp = answer.charAt(i);
    		System.out.print((char)(tmp^32));
    		}
    	}
    	
}
