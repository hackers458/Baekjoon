import java.util.*;




class Dust {
    int x;
    int y;
    int amount;

    Dust(int x, int y, int amount) {
        this.x = x;
        this.y = y;
        this.amount = amount;
    }

    void diffusion(int[][] xy, int[][] array) {
        int piece = (int)(this.amount / 5);//알아서 반내림 함
        for (int i = 0; i < 4; i++) { // 먼저 갈 수 있는 곳 확인하기
            int new_x = this.x + xy[i][0];
            int new_y = this.y + xy[i][1];
            if (new_x >= 0 && new_x < array[0].length && new_y >= 0 && new_y < array.length) {
                if (!(Main.air_purifier[0].x == new_x && Main.air_purifier[0].y == new_y) && !(Main.air_purifier[1].x == new_x && Main.air_purifier[1].y == new_y))// 에어컨 안겹치게
                {
                    array[new_y][new_x] += piece;
                    amount -= piece;
                }
            }
        }
        array[this.y][this.x] +=amount;
    }
}
class Air_purifier{
    int x;
    int y;
    Air_purifier(int x,int y){
        this.x = x;
        this.y = y;
    }

    void on(int[][]array,int index){
        int air_x = this.x+1;
        int air_y = this.y;
        Deque<Integer> dust_queue = new ArrayDeque<>(); // 사각형의 각 변 4개를 한줄로 생각 그리고 한칸 밀리면 한칸 없에는 걸 생각
        if(index == 0){ // 공기 청정기중 위에 부분
            while(air_x != array[0].length){
                dust_queue.add(array[air_y][air_x++]);
            }
            air_x--;
            air_y--;
            while(air_y != -1){
                dust_queue.add(array[air_y--][air_x]);
            }
            air_y++;
            air_x--;
            while(air_x != -1){
                dust_queue.add(array[air_y][air_x--]);
            }
            air_x++;
            air_y++;
            while(air_y != this.y){
                dust_queue.add(array[air_y++][air_x]);
            }
            // 큐가 지금 공기청정기 제외한 칸을 갖고 있음 -> 0추가하고 맨 뒤 제거
            dust_queue.addFirst(0);
            dust_queue.pollLast();
            //다시 큐에 있는거 대입
            air_x = this.x+1;
            air_y = this.y;
            while(air_x != array[0].length){
                array[air_y][air_x++]=dust_queue.pollFirst();
            }
            air_x--;
            air_y--;
            while(air_y != -1){
                array[air_y--][air_x]=dust_queue.pollFirst();
            }
            air_y++;
            air_x--;
            while(air_x != -1){
                array[air_y][air_x--]=dust_queue.pollFirst();
            }
            air_x++;
            air_y++;
            while(air_y != this.y){
                array[air_y++][air_x]=dust_queue.pollFirst();
            }

        }// 공기 청정기 중 아래 부분
        else{ // 공기 청정기 중 아래 부분
            while(air_x != array[0].length){
                dust_queue.add(array[air_y][air_x++]);
            }
            air_x--;
            air_y++;
            while(air_y != array.length){
                dust_queue.add(array[air_y++][air_x]);
            }
            air_y--;
            air_x--;
            while(air_x != -1){
                dust_queue.add(array[air_y][air_x--]);
            }
            air_x++;
            air_y--;
            while(air_y != this.y){
                dust_queue.add(array[air_y--][air_x]);
            }
            // 큐가 지금 공기청정기 제외한 칸을 갖고 있음 -> 0추가하고 맨 뒤 제거
            dust_queue.addFirst(0);
            dust_queue.pollLast();
            //다시 큐에 있는거 대입
            air_x = this.x+1;
            air_y = this.y;
            while(air_x != array[0].length){
                array[air_y][air_x++]=dust_queue.pollFirst();
            }
            air_x--;
            air_y++;
            while(air_y != array.length){
                array[air_y++][air_x]=dust_queue.pollFirst();
            }
            air_y--;
            air_x--;
            while(air_x != -1){
                array[air_y][air_x--]=dust_queue.pollFirst();
            }
            air_x++;
            air_y--;
            while(air_y != this.y){
                array[air_y--][air_x]=dust_queue.pollFirst();
            }
        }
    }
}


public class Main {
    static Air_purifier[] air_purifier = new Air_purifier[2];
    public static void main(String[] args) {
        int[][] xy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();

        Queue<Dust> dust_queue = new LinkedList();
        int[][] array = new int[R][C];
        int tmp = 0; // 에어컨 인덱스

        for(int i = 0; i < R; ++i) {
            for(int j = 0; j < C; ++j) {
                int num = sc.nextInt();
                if (num == -1) {
                    air_purifier[tmp++] = new Air_purifier(j, i);
                } else if (num != 0) {
                    dust_queue.add(new Dust(j, i, num));
                }
            }
        }
        int sum =0;
        for(int i = 0; i <T; ++i) {
            sum = 0;
            while(!dust_queue.isEmpty()){
                Dust poll = dust_queue.poll();
                poll.diffusion(xy, array);
            }

            for(int j = 0;j<2;j++){
                air_purifier[j].on(array,j); // 한칸씩 밀기
            }

            for(int k =0;k< R;k++){
                for(int j = 0;j<C;j++){
                    if(array[k][j] != 0) {
                        sum += array[k][j];
                        dust_queue.add(new Dust(j, k, array[k][j]));
                    }
                    array[k][j] = 0;
                }
            }
        }

        System.out.println(sum);

    }
}
