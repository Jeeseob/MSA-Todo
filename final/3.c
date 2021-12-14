#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

#include <errno.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>

#include <unistd.h>


#define N 100000000


union semun {
    int val;
    struct semid_ds *buf;
    unsigned short *array;
};


int initsem(key_t semkey) 
{
    	union semun semunarg;
    	int status = 0, semid;

    	semid = semget(semkey, 1, IPC_CREAT | IPC_EXCL | 0600);
    	if (semid == -1) 
	{
        	if (errno == EEXIST)
            		semid = semget(semkey, 1, 0);
    	}
    	else 
	{
        	semunarg.val = 1;
        	status = semctl(semid, 0, SETVAL, semunarg);
    	}

    	if (semid == -1 || status == -1) 
	{
        	perror("initsem");
        	return (-1);
    	}

    	return semid;
}



int semlock(int semid) 
{
    	struct sembuf buf;

    	buf.sem_num = 0;
    	buf.sem_op = -1;
    	buf.sem_flg = SEM_UNDO;
    	if (semop(semid, &buf, 1) == -1)
	{
        	perror("semlock failed");
        	exit(1);
    	}
    	return 0;
}

int semunlock(int semid) 
{
    	struct sembuf buf;

    	buf.sem_num = 0;
    	buf.sem_op = 1;
    	buf.sem_flg = SEM_UNDO;
    	if (semop(semid, &buf, 1) == -1) 
	{
        	perror("semunlock failed");
        	exit(1);
    	}
    	return 0;
}


unsigned int s = 0;

//pthread의 상호배제 기능을 사용해서 
//코드를 고치고 컴파일해서 결과를 보이시오.

// s에 1을 더하는 것을 N번 반복하는 함수 
void *c(void *d) {
	int i;


	int semid;
    	pid_t pid = getpid();

    	if ((semid = initsem(1)) < 0)
        	exit(1);


    semlock(semid);	

	for (i = 0; i < N; i++) {
		s++;
	}

	semunlock(semid);


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