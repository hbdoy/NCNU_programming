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
    int x;
    scanf("%d",&x);
    printf("%d",k(x));
}