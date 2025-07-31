#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int array[9];
int stack[1000];
int N, M;


int compare(const void* a, const void* b)
{
	if (*(int*)a > *(int*)b) return 1;
	else if (*(int*)a < *(int*)b) return -1;
	else return 0;
}


void backtracking(int depth,int start)
{
	static int first;

	if (depth == M) {
		for (int i = 0; i < M; i++) {
			printf("%d ", stack[i]);
		}
		printf("\n");
		return;
	}

	int pre = 0;
	for (int i = start; i < N; i++) {
		if (pre != array[i]) {
			pre = array[i];
			stack[depth] = array[i];
			backtracking(depth + 1,i);

		}
	}
	return;
}

int main(void) {


	scanf("%d %d", &N, &M);// 범위와 수열의 길이
	for (int i = 0; i < N; i++) {
		scanf("%d", &array[i]);
	}


	qsort(array, N, sizeof(int), compare);
	backtracking(0,0);

	return 0;
}