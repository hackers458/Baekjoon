#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

char *passw(char *pass,int len) {
	if (len >9||len < 6)
	{
		return "no";
	}
	else {
		return "yes";
	}
}


int main() {
	int i;
	scanf("%d", &i);
	char password[1000];
	for (int j = 0; j < i; j++) {
		scanf("%s", password);
		printf("%s\n", passw(password, strlen(password)));
	}


}