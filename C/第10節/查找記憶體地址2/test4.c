#include <stdio.h>

int fun(int x){
    x=0;
    printf("address of x in fun %p\n",&x);
    printf("value of x in fun %d\n",x);
}

int main(){
    int x=100;
    printf("address of x in main %p\n",&x);
    fun(x);
    printf("value of x in main %d\n",x);
}