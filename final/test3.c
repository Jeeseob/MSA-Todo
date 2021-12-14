#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>


#define N 100000000

unsigned int s = 0;

//pthread의 상호배제 기능을 사용해서 
//코드를 고치고 컴파일해서 결과를 보이시오.

// s에 1을 더하는 것을 N번 반복하는 함수 
void *c(void *d) {
	int i;

	for (i = 0; i < N; i++) {
		s++;
	}

	return NULL;
	
}

int main(void) {

	pthread_t t[2];
	int r;

	r = pthread_create(&t[0], NULL, c, NULL);
	if(r) {
		perror("Thread create: ");
		exit(1);
	}

	r = pthread_create(&t[1], NULL, c, NULL);
	
	if(r) {
		perror("Thread create: ");
		exit(2);
	}

	pthread_join(t[0], NULL);
	pthread_join(t[1], NULL);
	printf("%u\n", s);

	return 0;
}