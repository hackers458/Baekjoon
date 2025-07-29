import java.util.*;

public class Main {
    static int[][] dp;
    static Set<String> resultSet = new HashSet<>();
    static List<Integer> A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList<>();
        A.add(0);  // 1-based index
        for (int i = 0; i < N; i++) A.add(sc.nextInt());

        int M = sc.nextInt();
        B = new ArrayList<>();
        B.add(0);  // 1-based index
        for (int i = 0; i < M; i++) B.add(sc.nextInt());

        dp = new int[N + 1][M + 1];

        // LCS DP 채우기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A.get(i).equals(B.get(j))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        List<Integer> result = getGreedyBiggestCommonSubsequence(N, M);

        if (result.isEmpty()) {
            System.out.println(0);
            System.out.println();
        } else {
            System.out.println(result.size());
            for (int num : result)
                System.out.print(num + " ");
        }
    }

    static List<Integer> getGreedyBiggestCommonSubsequence(int n, int m) {
        List<Integer> res = new ArrayList<>();
        int i = 1, j = 1;

        while (i <= n && j <= m) {
            int max = -1;
            int nextI = -1, nextJ = -1;

            // 가능한 다음 공통 숫자 중 가장 큰 것 찾기
            for (int x = i; x <= n; x++) {
                for (int y = j; y <= m; y++) {
                    if (A.get(x).equals(B.get(y))) {
                        int val = A.get(x);
                        if (val > max) {
                            max = val;
                            nextI = x;
                            nextJ = y;
                        }
                    }
                }
            }

            if (nextI == -1 || nextJ == -1) break;

            res.add(max);
            i = nextI + 1;
            j = nextJ + 1;
        }

        return res;
    }
}