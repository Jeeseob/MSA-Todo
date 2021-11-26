#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(void)
{	
	pid_t pid;
	
	for (int i = 0; i<3; i++) {
		if((pid = fork()) < 0)
		{
			//자식 프로세스 생성 중 오류 발생시 에러 메세지 출력 및 료
			perror("fork");
			exit(1);
		}

		// pid가 양수이면, 부모 프로세스이기 때문에, 자식 프로세스 일때만 동작.
		if(pid <= 0)
		{
			printf("my pid is %d ppid is %d\n", (int)getpid()
				, (int)getppid());
			// pid, ppid 출력 후 종료
			return 0;
		}	
	}
	return 0;
}