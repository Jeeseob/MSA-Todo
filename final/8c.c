#include <sys/types.h>
#include <sys/socket.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

#define PORTNUM 9000

// int main(int argc, char *argv[])  
// {
//     	char buf[256];
//     	struct sockaddr_in sin, cli;
//     	int sd, ns, clientlen = sizeof(cli);

//     	if ((sd = socket(AF_INET, SOCK_STREAM, 0)) == -1) 
// 	{
//         	perror("socket");
//         	exit(1);
//     	}

//     	memset((char *)&sin, '\0', sizeof(sin));
//     	sin.sin_family = AF_INET;
//     	sin.sin_port = htons(PORTNUM);
//     	sin.sin_addr.s_addr = inet_addr("127.0.0.1");



//     	if (bind(sd, (struct sockaddr *)&sin, sizeof(sin))) 
// 	{
//         	perror("bind");
//         	exit(1);
//     	}

//     	if (listen(sd, 5)) 
// 	{
//         	perror("listen");
//         	exit(1);
//     	}


//     	if ((ns = accept(sd, (struct sockaddr *)&cli, &clientlen)) == -1) 
// 	{
//         	perror("accept");
//         	exit(1);
//     	}


//     	sprintf(buf, "Your IP address is %s", inet_ntoa(cli.sin_addr));


//     	if (send(ns, buf, strlen(buf) + 1, 0) == -1) 
// 	{
//         	perror("send");
//         	exit(1);
//     	}
//     	close(ns);
//     	close(sd);

//     	return 0;
// }


int main(int argc, char *argv[]) 
{
    	int sd;
    	char buf[256];
    	struct sockaddr_in sin;

    	if ((sd = socket(AF_INET, SOCK_STREAM, 0)) == -1) 
	{
        	perror("socket");
        	exit(1);
    	}

    	memset((char *)&sin, '\0', sizeof(sin));
    	sin.sin_family = AF_INET;
    	sin.sin_port = htons(PORTNUM);
    	sin.sin_addr.s_addr = inet_addr("127.0.0.1");

    	if (connect(sd, (struct sockaddr *)&sin, sizeof(sin))) 
	{
        	perror("connect");
        	exit(1);
    	}

    	if (recv(sd, buf, sizeof(buf), 0) == -1) 
	{
        	perror("recv");
        	exit(1);
    	}
    	close(sd);
    	printf("From Server : %s\n", buf);

    	return 0;
}