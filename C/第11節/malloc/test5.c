#include <stdio.h>
#include <math.h>
#include <stdlib.h>
int main(){
    int *x;
    long long sum;
    double dev,mean;
    int n,i;
    scanf("%d",&n);
    x=(int *)malloc(n*sizeof(int));
    for(i=0;i<n;i++){
        scanf("%d",&x[i]);
    }
    sum=0;
    for(i=0;i<n;i++){
        sum=sum+x[i];
    }
    printf("M = %lf\n",mean=(double)sum/n);
    dev=0;
    for(i=0;i<n;i++)
        dev=dev+(x[i]-mean)*(x[i]-mean);
    printf("SD = %lf\n",sqrt(dev/n));
    
}