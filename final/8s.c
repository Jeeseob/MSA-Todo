#include <sys/types.h>
#include <sys/socket.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

#include <ctype.h>

#define PORTNUM 9000

int main(void) 
{
    	char buf[256];
    	struct sockaddr_in sin, cli;
    	int sd, ns, clientlen = sizeof(cli);

    	if ((sd = socket(AF_INET, SOCK_STREAM, 0)) == -1) 
	{
        	perror("socket");
        	exit(1);
    	}

    	memset((char *)&sin, '\0', sizeof(sin));
    	sin.sin_family = AF_INET;
    	sin.sin_port = htons(PORTNUM);
    	sin.sin_addr.s_addr = inet_addr("127.0.0.1");

    	if (bind(sd, (struct sockaddr *)&sin, sizeof(sin))) 
	{
        	perror("bind");
        	exit(1);
    	}

    	if (listen(sd, 5)) 
	{
        	perror("listen");
        	exit(1);
    	}

    while (1) 
	{
        if ((ns = accept(sd, (struct sockaddr *)&cli, &clientlen)) == -1) {
            perror("accept");
            exit(1);
        }
        switch (fork()) {

            case 0:
       //         	while (input[count]) {
       // 				if (isupper(input[count])){
       //      			input[count] = tolower(input[count]);
       // 				}
       //  			else if (islower(input[count])){
       //      			input[count] = toupper(input[count]);
       // 				}
       //  		count++;
    			// }
            printf("test\n");

        }
    close(ns);
    }	

    	return 0;
}