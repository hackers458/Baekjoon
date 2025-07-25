import java.util.*;

class Node implements Comparable<Node> {
    int city;
    int cost;

    public Node(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) { //작은것부터
        return this.cost - o.cost;
    }
}

public class Main {
    static final int INF = 1_000_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도시 수
        int m = sc.nextInt(); // 버스 수

        ArrayList<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph[from].add(new Node(to, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curCity = current.city;
            int curCost = current.cost;

            if (dist[curCity] < curCost) continue;

            for (Node next : graph[curCity]) {
                int nextCity = next.city;
                int nextCost = curCost + next.cost;

                if (dist[nextCity] > nextCost) {
                    dist[nextCity] = nextCost;
                    parent[nextCity] = curCity;
                    pq.add(new Node(nextCity, nextCost));
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int cur = end;
        while (cur != 0) {
            stack.push(cur);
            cur = parent[cur];
        }

        System.out.println(dist[end]);
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    // 기존에 우선순위큐를 안써서 우선순위 큐로 사용
}