#include <stdio.h>

int s(int *x,int *y){
    int t;
    t=*x;
    *x=*y;
    *y=t;
}
int main(){
    int x=100,y=0;
    printf("before x=%d,y=%d\n",x,y);
    s(&x,&y);
    printf("after x=%d,y=%d\n",x,y);
    

}