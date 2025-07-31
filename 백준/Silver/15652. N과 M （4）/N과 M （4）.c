#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int array[1000];
int top = -1;
int N, M;





void backtracking(int a)
{
	if (top == M-1) {
		for (int i = 0; i <M; i++) {
			printf("%d ", array[i]);
		}
		top--;
		printf("\n");
	}
	else
	{
		for (int i = a; i <= N; i++)
		{
			array[++top] = i;
			backtracking(i);
		}
		top--;
	}
}

int main(void){


	scanf("%d %d", &N, &M);// 범위와 수열의 길이
	

	backtracking(1);
	



	return 0;
}