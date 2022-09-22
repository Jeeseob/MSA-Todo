#include <stdio.h>

int main(void) {
	int s;
	int sum = 0;

	for (s = 1; s<10; s++)
		sum = sum +s;

	printf("s = %d",s);

	printf("sum = %d\n", sum);
	return 0;
}