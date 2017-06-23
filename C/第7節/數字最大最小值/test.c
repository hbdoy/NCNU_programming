#include <stdio.h>

int main(){
    int n,i,max=-1,next;
    int min=1000001;
    scanf("%d",&n);
    for(i=1;i<=n;i=i+1){
        scanf("%d",&next);
        if(next>max)
            max=next;
        if(next<min)
            min=next;
    }
    printf("max=%d\nmin=%d",max,min);
}