#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MAX(a, b) (((a) > (b)) ? (a) : (b))

int triangle[501][501];

int main() {
	int N;
	scanf("%d", &N);


	for (int i = 0; i < N; i++) {
		for (int j = 0; j <=i; j++) {
			scanf("%d",&triangle[i][j]);
		}
	}


	for (int depth = N-1; depth >= 1; depth--) { // 1 23 456 78910 이있을 때 N = 4; 즉 depth는 3부터 시작
		for (int position = 0; position <= depth - 1; position++) { // 7 8 9 10에서 10은 보면 안되기에 depth -1
			triangle[depth - 1][position] = triangle[depth - 1][position] + MAX((triangle[depth][position]), (triangle[depth][position+1]));
			
		}
	}
	printf("%d", triangle[0][0]);

}
