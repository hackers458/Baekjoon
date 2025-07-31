#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
long long div = 1000000007;
long long new_a;
long long new_b;
long long new_c;
long long new_d;
long long tmp[4] = { 1,1,1,0 };
void fibo(long long h) {
	if (h == 1) { // 탈출조건
		return;
	}
	fibo(h / 2);
	if (h % 2 == 0) {//짝수면 구한거 바로 더하기
		new_a = (((tmp[0] * tmp[0]) + (tmp[1] * tmp[2]))) % div;
		new_b = ((tmp[0] * tmp[1]) + (tmp[1] * tmp[3])) % div;
		new_c = ((tmp[2] * tmp[0]) + (tmp[3] * tmp[2])) % div;
		new_d = ((tmp[2] * tmp[1]) + (tmp[3] * tmp[3])) % div;
		tmp[0] = new_a;
		tmp[1] = new_b;
		tmp[2] = new_c;
		tmp[3] = new_d;
	}
	else {//홀수면 나누고 a한번 더 곱
		new_a = (((tmp[0] * tmp[0]) + (tmp[1] * tmp[2]))) % div;
		new_b = ((tmp[0] * tmp[1])+(tmp[1] * tmp[3]))%div;
		new_c = ((tmp[2] * tmp[0])+ (tmp[3] * tmp[2]))%div;
		new_d = ((tmp[2] * tmp[1]) + (tmp[3] * tmp[3]))%div;
		tmp[0] = ((new_a)+(new_b))%div;
		tmp[1] = new_a;
		tmp[2] = (new_c+new_d)%div;
		tmp[3] = new_c;
	}
}


int main() {
	long long n;
	scanf("%lld", &n);
	fibo(n);
	printf("%lld", tmp[1]);
	return 0;
}
