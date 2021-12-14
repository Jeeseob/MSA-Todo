#include <stdlib.h>  
#include <stdio.h>  
#include <glib.h>


int main(int argc, char *argv[])  
{  
        int i;  
        
        printf("Queue Order\n");
        GQueue* queue = g_queue_new();

        for (i = 0; i< argc; i++) {
                g_queue_push_head(queue, argv[i]);
        }  

        while (!g_queue_is_empty(queue)) {
                printf("%s\n", (char*)g_queue_pop_tail(queue));
        }
        printf("\n");


        printf("Stack Order\n");
        
        for (i = 0; i< argc; i++) {
                g_queue_push_head(queue, argv[i]);
        } 

        while (!g_queue_is_empty(queue)) {
                printf("%s\n", (char*)g_queue_pop_heaed(queue));
        }



        exit(0);  
}  


