import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Stack;
//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.



class pipe{
    int state; // 1 은 가로 2는 세로 3은 대각선이라고 생각..
    int x;
    int y;

    pipe(int state,int x,int y){
        this.state = state;
        this.x = x;
        this.y = y; //파이프의 끝부분만 생각
    }
        }



public class Main {

    static int[][] array;
    static int count = 0;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        array = new int[N][N];
        for(int i = 0;i<N;i++){ // 배열 초기화
            StringTokenizer input = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                array[i][j]= Integer.parseInt(input.nextToken());
            }
        }

        pipe init = new pipe(1,1,0);
        dp(init);
        System.out.println(count);
    }

    public static void dp(pipe pipe1){
        if(pipe1.x == N-1 && pipe1.y == N-1)
        {
            count++;
            return;
        }
        if(pipe1.state == 1){ // 가로
            if(pipe1.x+1<N && wall_pipe(pipe1,1))
            {
                dp(new pipe(1,pipe1.x+1,pipe1.y));
            }
            if(pipe1.x+1<N && pipe1.y+1<N&& wall_pipe(pipe1,3))
            {
                dp(new pipe(3,pipe1.x+1,pipe1.y+1));
            }
        }
        else if(pipe1.state == 2){ // 세로
            if(pipe1.y+1<N&& wall_pipe(pipe1,2))
            {
                dp(new pipe(2,pipe1.x,pipe1.y+1));
            }
            if(pipe1.x+1<N && pipe1.y+1<N&& wall_pipe(pipe1,3))
            {
                dp(new pipe(3,pipe1.x+1,pipe1.y+1));
            }
        }
        else if(pipe1.state == 3){ // 대각선
            if(pipe1.x+1<N&& wall_pipe(pipe1,1))
            {
                dp(new pipe(1,pipe1.x+1,pipe1.y));
            }
            if(pipe1.y+1<N&& wall_pipe(pipe1,2))
            {
                dp(new pipe(2,pipe1.x,pipe1.y+1));
            }
            if(pipe1.x+1<N && pipe1.y+1<N&& wall_pipe(pipe1,3))
            {
                dp(new pipe(3,pipe1.x+1,pipe1.y+1));
            }
        }


    }


    public static boolean wall_pipe(pipe pipe1,int type1){ // 단순히 파이프가 벽에 부딛치는지 확인해주는 함수, 부딫칠시 false을 반환, 안붙이치면 true 반환
        if(type1 == 1){ // 가로만
            if(array[pipe1.y][pipe1.x+1] == 1)
            {
                return false;
            }
        }
        else if(type1 == 2){ //세로만
            if(array[pipe1.y+1][pipe1.x] == 1)
            {
                return false;
            }

        }
        else if(type1 == 3){ // 대각선만
            if(array[pipe1.y+1][pipe1.x+1] == 1 || array[pipe1.y][pipe1.x+1] == 1||array[pipe1.y+1][pipe1.x] == 1)
            {
                return false;
            }

        }
        return true;
    }



}



