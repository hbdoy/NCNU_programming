#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(){
    int p,i,j,k=0,k1=0,n,l,tmp;
    printf("input number:");
    scanf("%d",&p);
    int a[p*p];
    int b[p*p];
    srand(time(NULL));
    for(i=0;i<p;i++){
        for(j=0;j<p;j++,k++){
            n=rand()%100;
            printf("%2d  ",n);
            a[k]=n;
        }
        printf("\n");
    }
    printf("\n\n");
    k=0;
    l=p-1;
    for(i=1;i<=p;i++){
        for(j=0;j<p;j++,k++,l--){
            tmp=a[k];
            a[k]=a[l];
            a[l]=tmp;
        }
        k=i*p;
        l=k+p-1;
    }
    k=0;
    for(i=0;i<p;i++){
        for(j=0;j<p;j++,k++){
            printf("%2d  ",a[k]);
        }
        printf("\n");
        
    }
}