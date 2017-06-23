#include <stdio.h>
int fun(int x,int n){
    if(n==0)
        return 1;
    return x*fun(x,n-1);
}
int main(){
    int n,x;
    scanf("%d%d",&x,&n);
    printf("fun=%d\n",fun(x,n));
}
