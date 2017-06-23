#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct coin{
    int n; //kinds of coins
    int *value; //array of value for each coin
    double *weight; //weight of each coin
    int *available; //available number for each coin
    int *number; //number of coins to fit target
    int *maxnum; //max solution for each coin
    double max;
};
void init(struct coin*x,int n,int *v,double *w,int *a){
    int i;
    x->n=n;
    x->value=(int *)malloc(sizeof(int)*n);
    x->weight=(double *)malloc(sizeof(double)*n);
    x->available=(int *)malloc(sizeof(int)*n);
    x->number=(int *)malloc(sizeof(int)*n);
    x->maxnum=(int *)malloc(sizeof(int)*n);
    x->max=0;
    //copy data
    for(i=0;i<n;i++){
        x->value[i]=v[i];
        x->weight[i]=w[i];
        x->available[i]=a[i];
        x->number[i]=0;
    }
}
// from:from which kind of coin
void findsolution(struct coin*x,int target,int from){
    int i;
    if(x->n <=from){
        if(target==0){ //found a solution
        //check if this solution has max weight
            double w=0;
            for(i=0;i<x->n;i++){
                w+=x->weight[i]*x->number[i];
                if(w>x->max){
                    x->max=w;
                    for(i=0;i<x->n;i++){
                        x->maxnum[i]=x->number[i];
                    }
                }
            }
        }
        return;
    }
    //// choose coins from "from" position
    for(i=0;i<=x->available[from];i++){
        // choose i coins from "from" position
        x->number[from]=i;
        findsolution(x,target-x->value[from]*i,from+1);
    }
}
void main(){
    double w[]={10,7.5,4.4,3.8};
    int v[]={50,10,5,1};
    int a[4];
    int target,i;
    struct coin x;
    scanf("%d",&target);
    for(i=0;i<4;i++){
        scanf("%d",a+i);
    }
    init(&x,4,v,w,a);
    findsolution(&x,target,0);
    printf("%lf %d %d %d %d\n",x.max,x.maxnum[0],x.maxnum[1],x.maxnum[2],x.maxnum[3]);
}