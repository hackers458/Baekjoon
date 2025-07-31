import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Stack;
//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.

class xy{
    int x;
    int y;
    xy(int x, int y){
        this.x = x;
        this.y = y;
    }
}



public class Main {
    static int N;
    static int M;
    static int chicken_house;
    static int result = 9999999;
    static ArrayList<Integer>[] distance;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<xy> house = new ArrayList<>();
        ArrayList<xy> chicken = new ArrayList<>();
        distance = new ArrayList[13];

        for(int i =0; i<13;i++){
            distance[i] = new ArrayList<>();
        }
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        int[][] array = new int[N][N];
        for(int i = 0; i< N;i++){
            tokenizer = new StringTokenizer(bf.readLine());
            for(int j = 0; j<N;j++){
                int h = Integer.parseInt(tokenizer.nextToken());
                if (h == 1){
                    house.add(new xy(i,j));
                }
                else if(h == 2){
                    chicken.add(new xy(i,j));
                }
                array[i][j] = h;
            }
        }

        for(int i = 0;i<chicken.size();i++){
            for(int j =0;j<house.size();j++){
                distance[i].add(disdis(chicken.get(i),house.get(j)));
            }
        }
        chicken_house = chicken.size();
        ArrayList<Integer> tmp = new ArrayList<>();
        backtracking(0,tmp);
        System.out.println(result);



    }
    public static int disdis(xy chicken,xy house){ // 거리 구하는 함수
        return Math.abs(chicken.x-house.x)+Math.abs(chicken.y-house.y);
    }

    public static int backtracking(int index,ArrayList<Integer> tmp){
        if(tmp.size() == M) {
            boolean[] visit = new boolean[distance[0].size()]; // 모든 거리의 개수는 똑같다 == 집의 개수
            return real_backtracking(visit,tmp);
        }
        else{
            for(int i = index;i<chicken_house;i++)
            {
                tmp.add(i);
                result = Math.min(result,backtracking(i+1,tmp));
                tmp.remove(tmp.size()-1);
            }
        }

        return result;// 임시
    }


    public static int real_backtracking(boolean[] visit,ArrayList<Integer> tmp){
        int result1 = 0;

        for(int i = 0; i<distance[0].size();i++){ // 6개의 집이 있다고 생각
            int tmp2 = 99999;
            for(int j =0; j<tmp.size();j++){ // 3개의 치킨집이 있다고 생각
                tmp2 = Math.min(tmp2,distance[tmp.get(j)].get(i));
            }
            result1 += tmp2;
        }
        return result1;
    }


}



