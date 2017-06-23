#include <stdio.h>

int fun(int x){
    x=0;
    printf("address of x in fun %p\n",&x);
    printf("value of x in fun %d\n",x);
}

int main(){
    int x=100;
    int *p; //p is a pointer to int
    printf("address of x in main %p\n",&x);
    p=&x;
    printf("value of x in main %d\n",x);
    printf("address of p in main %p\n",p);
}