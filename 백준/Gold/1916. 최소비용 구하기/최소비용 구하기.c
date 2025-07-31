#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define INF 99999999


long long cost1[1001][1001];
long long distance[1001];
int visit[1001];
int top = -1;

long long min(long long a, long long b) {
	return a > b ? b : a;
}






int current1() {
	int x = 0;
	int little = -1;
	for (int i = 1; i < 1001; i++) {
		if (visit[i] == 0 && distance[i] != INF)
			if (x == 0) {
				x = 1;
				little = i;
			}
			else
				if (distance[little] > distance[i])
					little = i;
	}
	visit[little] = 1;
	return little;

}

void daikstra(int start_point, int end_point) {
	for (int i = 1; i < 1001; i++) {
		distance[i] = INF;
	}
	if (cost1[start_point][start_point] != 0)
		distance[start_point] = cost1[start_point][start_point];
	else
		distance[start_point] = 0;
	int current = current1();
		while (current !=-1)
		{
			for (int i = 1; i < 1001; i++) {
				if (cost1[current][i] != INF&&current!=i)
				{
					distance[i] = min(distance[i], cost1[current][i] + distance[current]);
				}
			}
			current = current1();
		}
		printf("%lld", distance[end_point]);

	


}



int main()
{
	int N;
	scanf("%d", &N);
	int M;
	scanf("%d", &M);

	int start, end, cost;

	for (int i = 1; i < 1001; i++) {
		for (int j = 1; j < 1001; j++) {
			if (i != j)
				cost1[i][j] = INF;
			else
				cost1[i][j] = 0;
		}
	}

	for (int i = 0; i < M; i++) {
		scanf("%d %d %d", &start, &end, &cost);
		if (start != end) {
			if (cost1[start][end] != INF )
				cost1[start][end] = min(cost1[start][end], cost);
			else
				cost1[start][end] = cost;
		}
	}

	int start_point, end_point;
	scanf("%d %d", &start_point, &end_point);
	daikstra(start_point, end_point);


	return 0;
}
