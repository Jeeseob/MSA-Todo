#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>




void handler(int signo)
{
	// Signal 입력시 실행 (signal 관련 정보 출력)
	psignal(signo, "Received Signal:");
	sleep(5);
	printf("In Signal Handler, After Sleep\n");
}

int main(void)
{

	struct sigaction act;

	sigemptyset(&act.sa_mask);
	act.sa_flags = 0;
	// signal 처리 handler를 hnadler 함수로 지정
	act.sa_handler = handler;

	if(sigaction(SIGINT, &act, (struct sigaction *)NULL)  < 0)
	{
		// 오류 발생시 에러 메세지 출력
		perror("sigaction");
		exit(1);
	}

	int i;
	// 출력문을 찍고 1초 쉰다.
	for(i = 0; i < 10; i++)
	{
		printf("sleep 1 second...\n");
		sleep(1);
	}	
	return 0;
}