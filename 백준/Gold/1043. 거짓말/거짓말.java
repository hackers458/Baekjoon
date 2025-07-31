import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.HashSet;
//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.






public class Main {
    // 해당 방법은 유니온 - 파인드가 아닌 dfs로 풀었음, 나중에 유니온 파인드로 풀 예정
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tmp = new StringTokenizer(bf.readLine());
        int N,M;

        N = Integer.parseInt(tmp.nextToken());
        boolean[] truth_people = new boolean[N+1]; // 1번부터 최대 50까지이기에
        boolean[] visit = new boolean[N+1];
        M = Integer.parseInt(tmp.nextToken());
        HashSet<Integer>[] array = new HashSet[N+1];
        ArrayList<Integer>[] array2 = new ArrayList[M];
        for(int i =0;i <N+1;i++){
            array[i] = new HashSet<Integer>();
        }
        for(int i =0;i <M;i++){
            array2[i] = new ArrayList<Integer>();
        }
        StringTokenizer truth_input = new StringTokenizer(bf.readLine());
        int truth = Integer.parseInt(truth_input.nextToken());
        for(int i = 0; i< truth;i++){
            truth_people[Integer.parseInt(truth_input.nextToken())] = true; // 진실된 사람 목록
        }

        boolean check = false; // 만약 진실을 알고 있는 사람이 한명이라도 있으면 true로 하여 그 파티에 있는 사람들이 진실을 알게 됨
                                // 진실을 모르고 있는 사람도 알게 되어 그 사람만이랑 파티에 있어도 진실을 말해야 함.
        for(int i =0;i<M;i++) {
            truth_input = new StringTokenizer(bf.readLine());
            int h = Integer.parseInt(truth_input.nextToken());
            if(h!=1) {
                int start = Integer.parseInt(truth_input.nextToken());
                array2[i].add(start);
                for (int j = 0; j < h -1; j++) {
                    int end = Integer.parseInt(truth_input.nextToken());
                    array2[i].add(end);
                    array[start].add(end);
                    array[end].add(start);
                    start = end;
                }
            }
            else{
                array2[i].add(Integer.parseInt(truth_input.nextToken()));
            }
        }


        Stack<Integer> stack = new Stack<>(); // dfs로 풀기
        for(int i = 1;i<N+1;i++){
            if(truth_people[i]) {
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
            int m = stack.pop();
            if(!visit[m]) {
                visit[m] = true;
                for (Integer tmp2 : array[m]) {
                    if (!visit[tmp2]) {
                        stack.add(tmp2);
                        truth_people[tmp2] = true;
                    }
                }
            }
        }



        int result = 0;
        for(int i =0; i<M;i++){
            check = false;
            for(int j =1;j<N+1;j++){
                if(truth_people[j] && array2[i].contains(j)){
                    check = true;
                }
            }
            if(!check){
                result++;
            }
        }


System.out.println(result);




    }
}



