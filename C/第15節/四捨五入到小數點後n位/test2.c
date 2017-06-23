#include<stdio.h>
double fun(double x,int n){ 
    int i;
    for(i=0;i<n;i++){
        x=x*10;
    }
    x=(int)(x+0.5);
    x=(double)x;
    for(i=0;i<n;i++){
        x=x/10;
    }
    return x;
} 

int main(){ 
    double x;
    int n;
    scanf("%lf%d",&x,&n);
    printf("before x=%lf\n",x);
    printf("after x=%lf\n",fun(x,n));
} 
