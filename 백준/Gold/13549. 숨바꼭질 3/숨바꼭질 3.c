#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX_NUM 100000

int visit[200001];
int queue[MAX_NUM];

int front = -1, rear = -1;
void rear_input(int a) {
    rear = (rear+1)%MAX_NUM;
    queue[rear] = a;
}

int front_pop() {

    front = (front+1)%MAX_NUM;
    return queue[front];
}

void front_input(int a) {
    queue[front] = a;
    front = (front - 1 + MAX_NUM) % MAX_NUM;
}

int rear_pop()
{
    rear = (rear - 1 + MAX_NUM) % MAX_NUM;
    return queue[rear];
}



void bfs(int N, int K) {
    rear_input(N);
    visit[N] = 0;
    int tmp;

    while (1) {
        tmp = front_pop();
        if (tmp == K)
            break;
        else {
            if (tmp * 2 < 200001 && visit[tmp * 2] > visit[tmp])
            {
                visit[tmp * 2] = visit[tmp];
                front_input(tmp * 2);
            }
            if (visit[tmp -1] >visit[tmp] && tmp - 1 >= 0)
            {
                visit[tmp -1] = visit[tmp] + 1;
                rear_input(tmp - 1);
            }
            if (tmp + 1 < 200001 && visit[tmp + 1] > visit[tmp])
            {
                visit[tmp + 1] = visit[tmp] + 1;
                rear_input(tmp + 1);
            }
       
        }



    }

    printf("%d", visit[K]);
}



int main(void) {

    int N, K;
    
    for (int i = 0; i < 200001; i++) {
        visit[i] = 9999999;
    }

    scanf("%d %d", &N, &K); // 수빈 동생


    bfs(N, K);
    


  

    return 0;
}

