
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>
#include <stdio.h>


void handler(int signo) 
{
    	psignal(signo, "Received Signal:");
    	sleep(5);
    	printf("In Signal Handler, After Sleep\n");
}


int mina(void) {


	struct sigaction act;

    	sigemptyset(&act.sa_mask);
    	sigaddset(&act.sa_mask, SIGQUIT);
    	act.sa_flags = 0;
    	act.sa_handler = handler;
    	if (sigaction(SIGINT, &act, (struct sigaction *)NULL) < 0) 
	{
        	perror("sigaction");
        	exit(1);
    	}

    	fprintf(stderr, "Input SIGINT: ");
    	pause();
    	fprintf(stderr, "After Signal Handler\n");

    	return 0;


	// short i = 0;

	// while(1) {
	// 		if(i<0)
	// 			i = 0;
	// 		printf("%d\r",i++);
	// }
	// return 0;
}