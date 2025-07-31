#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define MAX_SIZE 10000
#define TRUE 1
#define FALSE 0


int result[101];
int visit[101];
int snake[101] = { 0 };
int ladder[101] = { 0 };

typedef struct queue {
	
	int queue[MAX_SIZE];
	int front;
	int rear;

}queue;
void init(queue* q) {
	q->front = q->rear = 0;
}
void append(queue* q, int a) {
	q->rear = (q->rear + 1) % MAX_SIZE;
	q->queue[q->rear] = a;

}
int min(int a, int b) {
	if (a == 0)
		return b;
	else
		return a > b ? b : a;
}
int pop(queue* q) {
	q->front = (q->front + 1) % MAX_SIZE;
	return q->queue[q->front];
}

int ladder_snake(int a,int count) {
	if (ladder[a] != 0 && visit[a] == FALSE) {
		visit[a] = TRUE;
		result[a] = count;
		return ladder_snake(ladder[a],count);
	}
	else if (snake[a] != 0 && visit[a] == FALSE) {
		visit[a] = TRUE;
		result[a] = count;
		return ladder_snake(snake[a],count);
	}
	else {
		if (visit[a] == FALSE) {
			visit[a] = TRUE;
			result[a] = count;
			return a;
		}
		else {
			return -1;
		}
	}

}





int main()
{
	for (int i = 0; i < 101; i++) {
		result[i] = 0;
		visit[i] = 0;
	}
	queue q;
	init(&q);
	int N, M; // 사다리, 뱀
	int h;
	int tmp1, tmp2, tmp3;


	scanf("%d %d",&N, &M);

	for (int i = 0; i < N; i++) {
		scanf("%d %d", &tmp1, &tmp2);
		ladder[tmp1] = tmp2;
	}
	for (int j = 0; j < M; j++) {
		scanf("%d %d", &tmp1, &tmp2);
		snake[tmp1] = tmp2;
	}

	int count = 0;

	append(&q, 1);

	while (result[100]==0) {
		tmp1 = q.rear;
		count++;
		while (q.front != tmp1) {
			tmp2 = pop(&q);
			for (int i = 1; i <= 6; i++) { // 1~6더하기
				if (tmp2 + i <= 100) { //100이 넘지 안도록 하기
					h = ladder_snake(tmp2 + i,count);
					if (h != -1)
						append(&q, h);
				}
			}
		}
	}
	printf("%d",result[100]);
	
	
	return 0;
}
