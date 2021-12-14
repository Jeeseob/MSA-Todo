#include <stdlib.h>  
#include <stdio.h>  
#include <string.h>
#include <glib.h>




void print(gpointer data, gpointer userdata) {
        printf("%s\t", (char*)data);
}

gint compare(gconstpointer a, gconstpointer b) {
        return (gint)strcmp(*(const char **)a, *(const char**)b);
}

gint reverse_compare(gconstpointer a, gconstpointer b){
    StructInfo* x = (StructInfo *)a;
    StructInfo* y = (StructInfo *)b;

    return (y->nValue1 - x->nValue1);
}

int main(int argc, char *argv[])  
{  
        int i;  
        
        printf("Queue Order\n");
        GQueue* queue = g_queue_new();

        for (i = 1; i< argc; i++) {
                g_queue_push_head(queue, argv[i]);
        }  

        while (!g_queue_is_empty(queue)) {
                printf("%s\t", (char*)g_queue_pop_tail(queue));
        }
        printf("\n");


        printf("Stack Order\n");
        
        for (i = 1; i< argc; i++) {
                g_queue_push_head(queue, argv[i]);
        } 

        while (!g_queue_is_empty(queue)) {
                printf("%s\t", (char*)g_queue_pop_head(queue));
        }

        printf("\n");

        GPtrArray* array = g_ptr_array_new();

        for(i=1; i<argc; i++) {
                g_ptr_array_add(array,argv[i]);
        }

        printf("Alphabetical Order\n");
        g_ptr_array_sort(array,compare);

        g_ptr_array_foreach(array,print,NULL);        
        printf("\n");


        printf("reverse Alphabetical Order\n");
        g_ptr_array_sort(array,compare2);

        g_ptr_array_foreach(array,print,NULL); 
        printf("\n");


        exit(0);  
}  


