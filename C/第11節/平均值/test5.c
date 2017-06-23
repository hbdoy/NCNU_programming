#include <stdio.h>
#include <math.h>
int main(){
    int n,i;
    int sum=0;
    float a;
    scanf("%d",&n);
    int arr[n];
    for(i=0;i<n;i++){
        printf("%d:\n",i+1);
        scanf("%d",&arr[i]);
    }
    for(i=0;i<n;i++){
        sum=sum+arr[i];
    }
    a=sum/n;
    printf("total is %d\n",sum);
    printf("average is %f\n",a);
}