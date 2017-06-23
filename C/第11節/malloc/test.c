#include <stdio.h>
#include <math.h>
#include <stdlib.h>
int main(){
    int *x;
    x=malloc(sizeof(int));
    *x=5;
    printf("%d",*x);
}