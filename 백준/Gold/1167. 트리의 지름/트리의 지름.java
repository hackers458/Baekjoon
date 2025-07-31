import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Stack;
//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.

class node{
    int distance;
    int end;
    node(int end,int distance){
        this.distance = distance;
        this.end = end;
    }
}


public class Main {
    public static void main(String[] args) throws IOException{
        boolean[]  visit = new boolean[100001];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<node>[] h = new ArrayList[100001];
        for(int i = 0; i<100001;i++){
            h[i] = new ArrayList<>();
        }
        int N = Integer.parseInt(bf.readLine());
        int start;
        StringTokenizer tokenizer;
        for(int i = 0;i<N;i++){
            tokenizer = new StringTokenizer(bf.readLine()," ");
            start = Integer.parseInt(tokenizer.nextToken());
            if(start == -1)
                continue;
            while(tokenizer.hasMoreTokens()){  // 시작 끝 거리
                    int end,distance;
                    end = Integer.parseInt(tokenizer.nextToken());
                    if(end == -1)
                        break;
                    distance = Integer.parseInt(tokenizer.nextToken());
                    h[start].add(new node(end,distance));
                    h[end].add(new node(start,distance));
                }
            }

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        visit[1] = true;
        int[] Realdistance = new int[100001];
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            for(int i = 0; i<h[tmp].size();i++){
                if(!visit[h[tmp].get(i).end]) {
                    stack.add(h[tmp].get(i).end);
                    visit[h[tmp].get(i).end] = true;
                    Realdistance[h[tmp].get(i).end] = h[tmp].get(i).distance +Realdistance[tmp] ;
                }
            }
        }


        int tmp = Realdistance[0];
        int result = 0;
        for(int i = 0;i<100001;i++){
            visit[i] = false;
            if(tmp < Realdistance[i]){
                tmp = Realdistance[i];
                result = i;
            }
            Realdistance[i] = 0;
        }



        stack.add(result);
        visit[result] = true;
        while(!stack.isEmpty()){
            int tmp2 = stack.pop();
            for(int i = 0; i<h[tmp2].size();i++){
                if(!visit[h[tmp2].get(i).end]) {
                    stack.add(h[tmp2].get(i).end);
                    visit[h[tmp2].get(i).end] = true;
                    Realdistance[h[tmp2].get(i).end] = h[tmp2].get(i).distance +Realdistance[tmp2] ;
                }
            }
        }

        int max = Arrays.stream(Realdistance).max().getAsInt();
        System.out.println(max);
        }
    }
