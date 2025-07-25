import java.util.*;

class node implements Comparable<node> {
    int end;
    int distance;

    node(int end, int distance) {
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(node o) {
        return this.distance - o.distance; // 거리 기준 오름차순
    }
}

public class Main {
    static final int INF = 9999999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도시 수
        int m = sc.nextInt(); // 버스 개수

        ArrayList<node>[] array = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();

            boolean updated = false;
            for (int j = 0; j < array[start].size(); j++) {
                node tmp = array[start].get(j);
                if (tmp.end == end) {
                    if (tmp.distance > dist) {
                        array[start].set(j, new node(end, dist));
                    }
                    updated = true;
                    break;
                }
            }
            if (!updated) {
                array[start].add(new node(end, dist));
            }
        }

        int start = sc.nextInt(); // 출발 도시
        int end = sc.nextInt();   // 도착 도시

        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        ArrayList<Integer>[] city = new ArrayList[n + 1]; // 경로 저장용
        for (int i = 0; i <= n; i++) {
            city[i] = new ArrayList<>();
        }
        city[start].add(start);

        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(start, 0));

        while (!pq.isEmpty()) {
            node cur = pq.poll();

            if (distance[cur.end] < cur.distance) continue;

            for (node nxt : array[cur.end]) {
                int newDist = distance[cur.end] + nxt.distance;
                if (distance[nxt.end] > newDist) {
                    distance[nxt.end] = newDist;
                    city[nxt.end].clear();
                    city[nxt.end].addAll(city[cur.end]);
                    city[nxt.end].add(nxt.end);
                    pq.offer(new node(nxt.end, newDist));
                }
            }
        }

        System.out.println(distance[end]);
        System.out.println(city[end].size());
        for (int c : city[end]) {
            System.out.print(c + " ");
        }
    }
}
