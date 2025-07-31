#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

long long GN;
long long matrix[5][5]; // 제곱한 값 저장
long long matrix2[5][5]; // 원본




void calcul(long long a[][5], long long b[][5]) {
	long long tmp[5][5];
	for (long long i = 0; i < 5; i++) {
		for (long long j = 0; j < 5; j++) {
			tmp[i][j] = 0;
		}
	}

	for (long long i = 0; i < GN; i++) {
		for (long long j = 0; j < GN; j++) {
			long long tmp1 = 0;
			while (tmp1 < GN) {
				tmp[i][j] += a[i][tmp1]*b[tmp1][j];
				tmp[i][j] = tmp[i][j] % 1000;
				tmp1++;
			}
			tmp1 = 0;
		}
	}
	for (long long i = 0; i < 5; i++) {
		for (long long j = 0; j < 5; j++) {
			matrix[i][j] = tmp[i][j]%1000;
		}
	}



	return;
}



void yaho(long long N) {
	if (N == 1) {
		return;
	}

	if (N % 2 == 0) {
		yaho(N / 2);
		calcul(matrix, matrix);
	}
	else if (N % 2 == 1) {
		yaho(N / 2);
		calcul(matrix, matrix);
		calcul(matrix2, matrix);
	}
	return;
}

int main() {
	long long N, B;


	
	scanf("%lld %lld", &N,&B);
	GN = N;
	for (long long i = 0; i < N; i++) {
		for (long long j = 0; j < N; j++) {
			scanf("%lld", &matrix[i][j]);
			matrix2[i][j] = matrix[i][j];
		}
	}
	yaho(B);
	for (long long i = 0; i < N; i++) {
		for (long long j = 0; j < N; j++) {
			printf("%lld ",matrix[i][j]%1000);
		}
		printf("\n");
	}





	
}