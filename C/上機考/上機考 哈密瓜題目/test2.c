#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(){
    int p[5000];
    int i,c,y=0,n=0,g=0;
    srand(time(NULL));
    for(i=0;i<5000;i++){
        c=rand()%2;
        p[i]=c;
    }
    for(i=0;i<5000;i++){
        if(p[i]==0){
            y=y+1;
            if(i%1000==0){
                g=g+1;
            }
        }else{
            n=n+1;
        }
    }
    printf("like %d\n",y);
    printf("Dislike %d\n",n);
    printf("gift %d\n",g);
}