#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int n, m;
int result[1000];
int check[10];

int dfs(int depth, int cut) {
    if (depth == m) { // 깊이가 m까지 왔다면 result 배열에 담은 순열을 출력해야함!
        for (int i = 0; i < m; i++) {
            printf("%d ", result[i]);
        }
        printf("\n");
        return; // 항상 마지막에는 종료해줘야함!!
    }

    for (int i = 1; i <= n; i++) {
        if (check[i] == 0 && cut < i) { // cut보다 i가 커야 더 큰숫자가 계속 들어가므로 오름차순이 된다!
            result[depth] = i;
            check[i] = 1;
            dfs(depth + 1, i); // cut을 i로 해줘서 뒤에 오는 숫자들이 i보다 커야함!
            check[i] = 0;
        }
    }
}

int main() {
    scanf("%d %d", &n, &m);
    dfs(0, 0); // depth, cut을 인자로 줌!

    return 0;
}