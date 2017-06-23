#include <stdio.h>
#include <stdlib.h>
#include <time.h>

double integrate(double (*f)(double),double a,double b,int n){
    int i;
    double sum=0;
    for(i=0;i<n;i++){
        sum=sum+((*f)((a+(b-a))/n*i)+(*f)((a+(b-a))/n*(i+1)))*(b-a)/n/2;
    }
    return sum;
} 

double fun1(double x){
    return x;
}

double fun2(double x){
    return x*x;
}

double fun3(double x){
    return x*x*x;
}
void main(){
    double a,b;
    int n;
    scanf("%lf%lf%d",&a,&b,&n);
    printf("%lf\n",integrate(fun1,a,b,n));
}