#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void print_star(int y, int x, int size) {
    if (size == 3) {
        if (y == 0 && x == 0) {
            printf("*");
        }
        else if (y == 1 && (x == -1 || x == 1)) {
            printf("*");
        }
        else if (y == 2 && x >= -2 && x <= 2) {
            printf("*");
        }
        else {
            printf(" ");
        }
        return;
    }

    int half = size / 2;

    if (y < half) {

        print_star(y, x, half);
    }
    else {

        if (x < 0) {
            print_star(y - half, x + half, half);
        }

        else {
            print_star(y - half, x - half, half);
        }
    }
}

int main() {
    int N;
    scanf("%d", &N);

    int W = 2 * N - 1;

    for (int y = 0; y < N; y++) {
        for (int x = 0; x < W; x++) {
            int dx = x - (W - 1) / 2;
            print_star(y, dx, N);
        }
        printf("\n");
    }

    return 0;
}
