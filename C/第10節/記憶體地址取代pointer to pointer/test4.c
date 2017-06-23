#include <stdio.h>

int main(){
    int x=100;
    int *p; //p is a pointer to int
    int **pp; //pp is a pointer to pointer to int
    p=&x;
    pp=&p;
    printf("address of x=%p\n\n",&x);
    printf("address of p=%p\n",p);
    printf("value of pp=%d\n",**pp);
    printf("address of pp=%p\n",pp);
}