import java.util.*;


class Shark implements Comparable<Shark>{
    int x;
    int y;
    int distance;
    int level;
    Shark(int x,int y,int level,int distance) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.distance = distance;
    }
    @Override
    public int compareTo(Shark h){
        if(this.distance == h.distance){
            if(this.y == h.y){
                return this.x-h.x;
            }
            return this.y-h.y;
        }
        return this.distance - h.distance;
    }
}

public class Main {
    static public void init_visit(boolean[][] tmp,int N){
        for(int i =0;i<N;i++){
            Arrays.fill(tmp[i],false);
        }
    }



    public static void main(String[] args) {

        int[][] xy = {{1,0},{0,1},{-1,0},{0,-1}}; // 첫번째 원소는 y, 두번째는 x라고 생각(의미없긴 함)
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int[][] array = new int[N][N];
        Shark im_shark = null;
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                int num = sc.nextInt();
                if(num == 9){
                    im_shark= new Shark(j,i,2,0);
                }
                array[i][j] = num;
            }
        }
        int result = 0; // 결과
        int exp = 0;//경험치 2개 쌓이면 레벨업
        PriorityQueue<Shark> tmp = new PriorityQueue<>();
        Queue<Shark> tmp2 = new LinkedList<>();

        boolean visit[][] = new boolean[N][N];


        while(true) {
            init_visit(visit, N);
            tmp2.add(im_shark);
            while (!tmp2.isEmpty()) { // 현재 갈 수 있는 가장 가까운 물고기 찾기
                Shark tmp3 = tmp2.poll();
                visit[im_shark.y][im_shark.x] = true;

                for (int i = 0; i < 4; i++) {
                    int tmp_x = tmp3.x + xy[i][1];
                    int tmp_y = tmp3.y + xy[i][0];
                    if ((tmp_x < N && tmp_x >= 0) && (tmp_y < N && tmp_y >= 0) && visit[tmp_y][tmp_x] == false) {// 만약 상하좌우가 범위 안에 있다면?
                        if (array[tmp_y][tmp_x] == 0 || array[tmp_y][tmp_x] == im_shark.level) {
                            tmp2.add(new Shark(tmp_x, tmp_y, array[tmp_y][tmp_x],(tmp3.distance+1)));
                            visit[tmp_y][tmp_x] = true;
                        } else {
                            if (array[tmp_y][tmp_x] < im_shark.level) {
                                Shark tmp4 = new Shark(tmp_x, tmp_y, array[tmp_y][tmp_x],(tmp3.distance+1));
                                tmp2.add(tmp4);
                                tmp.add(tmp4);// 먹을 수 있는 물고기 추가
                                visit[tmp_y][tmp_x] = true;

                            }
                        }
                    }


                }
            }//while문 끝(bfs)
            if(tmp.isEmpty())
                break;
            Shark prey = tmp.poll();
            exp++;
            result += prey.distance;
            array[im_shark.y][im_shark.x] = 0;
            im_shark.x = prey.x;
            im_shark.y = prey.y;
            array[im_shark.y][im_shark.x] = 9;
            tmp.clear();
            if(exp == im_shark.level) {
                im_shark.level++;
                exp=0;
            }
            array[prey.y][prey.x] = 0;


        }//전체
        System.out.println(result);

}
}
