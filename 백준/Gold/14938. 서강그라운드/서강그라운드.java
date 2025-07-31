import java.util.*;

class Node {
    int to, dist;
    Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}

public class Main {
    static int n, m, r;
    static int[] items;
    static ArrayList<Node>[] graph;

    static final int INF = 999_999;

    public static int dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist > dist[cur.to]) continue;

            for (Node next : graph[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.dist) {
                    dist[next.to] = dist[cur.to] + next.dist;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        // 거리 m 이하인 노드들의 아이템 합산
        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                total += items[i];
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 지역 수
        m = sc.nextInt(); // 수색 범위
        r = sc.nextInt(); // 길 수

        items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = sc.nextInt();
        }

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }

        System.out.println(answer);
    }
}
