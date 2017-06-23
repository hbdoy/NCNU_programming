#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(){
    int n,m,i,j,c1,c2,tmp,d,k;
    srand(time(NULL));
    scanf("%d",&n);
    int s[n];
    for(i=0;i<n;i++){
        s[i]=(i+1);
    }
    for(i=0;i<1000;i++){
        c1=rand()%n;
        c2=rand()%n;
        tmp=s[c1];
        s[c1]=s[c2];
        s[c2]=tmp;
    }
    for(i=0;i<n;i++){
        if(i%7==0){
            printf("\n");
        }
        printf("%2d ",s[i]);
    }
    printf("\n");
    scanf("%d",&m);
    int ds[m];
    for(i=0;i<m;i++){
        scanf("%d",&k);
        ds[i]=k;
        k=0;
    }
    for(i=0,j=0;i<n;i++){
        if(s[i]==ds[j]){
            s[i]=0;
            j=j+1;
        }
    }
    for(i=0;i<n;i++){
        if(i%7==0){
            printf("\n");
        }
        if(s[i]==0){
            printf("XX ");
            continue;
        }
        printf("%2d ",s[i]);
    }
}