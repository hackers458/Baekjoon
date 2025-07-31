import java.util.*;


class node{
    int x;
    int y;
    node(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static ArrayList<node> one = new ArrayList<node>(); //0의 위치 저장
    static ArrayList<node> two = new ArrayList<node>(); //2의 위치 저장
    static int[] x = {1,0,0,-1};
    static int[] y = {0,1,-1,0};
    static int N,M;
    static int[][] array;
    static public int back_tracking(int index, int count){
        int num = 0;
        if(count == 3){
            int result = bfs();
            return result;
        }
        else {
            for (int i = index; i <one.size(); i++) {
                array[one.get(i).y][one.get(i).x] = 1;
                num = Math.max(back_tracking(i+1,count+1),num);
                array[one.get(i).y][one.get(i).x] = 0;
            }

        }
        return num;
    }



    static public int bfs(){
        Queue<node> tmp = new LinkedList<node>();
        for(int i =0;i<two.size();i++){
            tmp.add(two.get(i));
        }
        node h;
        while(!tmp.isEmpty()){
            h = tmp.poll();
            for(int i=0;i<4;i++){
                int xx = h.x+x[i];
                int yy = h.y+y[i];
                if(xx<M&&xx>=0&&yy<N&&yy>=0){
                    if(array[yy][xx]==0)
                    {
                        array[yy][xx] = 2;

                        tmp.add(new node(xx,yy));
                    }
                }
                else{
                    continue;
                }
            }
        }
        int count = 0;
        for(int i=0;i<N;i++){ // 0 개수 세기 및 2인거 다 0으로 만들기
            for(int j=0;j<M;j++){
                if(array[i][j]==0){
                    count++;
                }
                if(array[i][j]==2){
                    array[i][j] = 0;
                }
            }
        }
        for(int i = 0; i<two.size();i++){// 0인것중 원래 2인거 만들기
            node tmp1 = two.get(i);
            array[tmp1.y][tmp1.x] = 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        array = new int[N][M];



        for(int i =0;i<N;i++){
            for(int j=0;j<M;j++){
                array[i][j]= sc.nextInt();
                if(array[i][j] == 0)
                    one.add(new node(j,i));
                if(array[i][j] == 2)
                    two.add(new node(j,i));
            }
        }

        System.out.println(back_tracking(0,0));




    }
}
