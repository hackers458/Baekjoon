#define _CRT_SECURE_NO_WARNINGS
#define MAX(a,b) ((a<b)?(b):(a))
#include<stdio.h>
#include<stdlib.h>


int main() {
	int N, M;
	scanf("%d %d", &N, &M);
	int answer = 0;
	int answer2 = 0;
	char** arr = (char**)malloc(sizeof(char*) * N);
	for (int i = 0; i < N; i++) {
		arr[i] = (char*)malloc(sizeof(char) * M + 1);
		scanf("%s", arr[i]);
	}

	for (int i = 0; i < N; i++) {
		int is_dot = 1;
		for (int j = 0; j < M; j++) {
			if (arr[i][j] == 'X')
			{
				is_dot = 0;
				break;
			}
		}
		if (is_dot) {
			answer++;
		}
	}

	for (int i = 0; i < M; i++) {
		int is_dot = 1;
		for (int j = 0; j < N; j++) {
			if (arr[j][i] == 'X')
			{
				is_dot = 0;
				break;
			}
		}
		if (is_dot) {
			answer2++;
		}
	}
	answer = MAX(answer, answer2);
	printf("%d",answer);
	for (int i = N-1; i >=0; i--) {
		free(arr[i]);
		arr[i] = NULL;
	}
	free(arr);
	arr = NULL;
}
