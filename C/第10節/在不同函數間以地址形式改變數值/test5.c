#include <stdio.h>

int main(){
    int x=100,y=0;
    int *p,*q;
    printf("before x=%p,y=%p\n",&x,&y);
    p=&x;
    q=&y;
    *p=555;
    *q=888;
    printf("after x=%d,y=%d\n",x,y);
}