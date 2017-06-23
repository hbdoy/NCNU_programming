#include <stdio.h>

void fun(){
    int x=0;
    printf("address of x in fun %p\n",&x);
}

int main(){
    int x=100,y;
    printf("address of x in main %p\n",&x);
    fun();
    printf("address of x in main %d\n",x);
}