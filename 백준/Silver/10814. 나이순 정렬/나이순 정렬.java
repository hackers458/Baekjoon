import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String>[] arr = new ArrayList[201];
        for(int i =0;i<201;i++){
            arr[i] = new ArrayList<String>();
        }
        int k = Integer.parseInt(br.readLine());
        int n;

        for(int j = 0;j<k;j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr[n].add(st.nextToken());
        }
        for(int i = 0;i<201;i++){
            if(!arr[i].isEmpty()){
                for(int j =0;j<arr[i].size();j++)
                bw.write(i + " " + arr[i].get(j)+"\n");
                bw.flush();
            }
        }
        }
    }