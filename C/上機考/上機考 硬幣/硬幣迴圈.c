#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void main(){
    int i,j,k,l,money,a,b,c,d;
    int x50,x10,x5,x1;
    double max=0;
    scanf("%d%d%d%d%d",&money,&a,&b,&c,&d);
    for(i=0;i<=a;i++){
        for(j=0;j<=b;j++){
            for(k=0;j<=c;k++){
                for(l=0;l<=d;l++){
                    if(50*i+10*j+5*k+l==money){
                        double w=10*i+7.5*j+4.4*k+3.8*l;
                        if(w>max){
                            max=w;
                            x50=i;
                            x10=j;
                            x5=k;
                            x1=l;
                        }
                    }
                }
            }
        }
    }
    printf("%d %d %d %d %d",x50,x10,x5,x1,max);
}