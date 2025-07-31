#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>




int main(void) {
    
    int** same;
    char first[1003];
    char next[1003];

    
    scanf("%s",first);
    scanf("%s",next);
    int first_len = strlen(first);
    int next_len = strlen(next);

    same = (int**)malloc(sizeof(int*) * (first_len+1));

    for (int i = 0; i < first_len+1; i++) {
        same[i] = (int*)malloc(sizeof(int) * (next_len+1));
        for (int j = 0; j < next_len+1; j++) {
            same[i][j] = 0;
        }
    }


    for (int i = 1; i < first_len+1; i++) {
        for (int j = 1; j < next_len+1; j++) {
            if (first[i-1] == next[j-1]) {
                same[i][j] = same[i-1][j-1] + 1;
            }
            else {
                same[i][j] = (same[i-1][j] > same[i][j-1]) ? same[i-1][j] : same[i][j-1];
            }
        }
    }

    int big = 0;
    for (int i = 0; i < first_len + 1; i++) {
        for (int j = 0; j < next_len+1; j++) {
            big = (big > same[i][j] ? big : same[i][j]);
        }
    }
    printf("%d", big);

    return 0;
}

