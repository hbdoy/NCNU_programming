#include <stdio.h>

double sqrt(double x)
{
    double right,mid,left;
    if(x>1){
        left=1;
        right=x;
    }else if(x<1){
        left=0;
        right=x;
    }
    mid=(left+right)/2;
    while (mid>left && mid<right)
    {
    if (mid*mid>x){
        right=mid;
    }else if(mid*mid<x){
        left=mid;
    }else 
        return mid;
        mid=(left+right)/2;
    }
    return mid;
}

int main(){
    double n;
    scanf("%lf",&n);
    printf("%lf",sqrt(n));
}