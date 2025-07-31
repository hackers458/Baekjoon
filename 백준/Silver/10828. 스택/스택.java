import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;
import javax.lang.model.element.Element;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        int size = 0;
        for(int i = 0;i<k;i++){
            String[] s = br.readLine().split(" ");
            switch(s[0]){
                case "push":
                    stack.push(Integer.parseInt(s[1]));
                    size++;
                    break;
                case "pop":
                    if(stack.empty())
                        bw.write("-1");
                    else {
                        bw.write(stack.pop()+ "");
                        size--;
                    }
                    bw.flush();
                    bw.newLine();
                    break;
                case "top":
                    if(stack.empty())
                        bw.write("-1");
                    else
                        bw.write(stack.peek()+ "");
                    bw.flush();
                    bw.newLine();
                    break;
                case "size":
                    bw.write(size+ "");
                    bw.flush();
                    bw.newLine();
                    break;
                case "empty":
                    if(stack.empty())
                        bw.write("1");
                    else
                        bw.write("0");
                    bw.flush();
                    bw.newLine();
                    break;
            }
            }
        bw.close();









        }







    }