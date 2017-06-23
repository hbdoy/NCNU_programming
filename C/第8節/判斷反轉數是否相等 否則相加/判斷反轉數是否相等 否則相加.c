#include <stdio.h>

int k(int x){
    int y=0,l;
    while(x!=0){
        l=x%10;
        y=y*10+l;
        x=x/10;
    }
    return y;
}

int main(){
    int x,n=0,i,j;
    scanf("%d",&j);
    for(i=1;i<=j;i=i+1){
        scanf("%d",&x);
    while(x!=k(x)){
        x=x+k(x);
        n=n+1;
    }
    printf("%d %d\n",n,k(x));
    }
}