#include <stdio.h>

void move(int n,int a,int b,int c){
    if(n==0)
        return;
    move(n-1,a,c,b);
    printf("%d %d\n",a,b);
    move(n-1,c,b,a);
}
int main(){
    int n;
    scanf("%d",&n);
    move(n,7,8,9);
}
