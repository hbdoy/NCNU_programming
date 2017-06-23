#include <stdio.h>

int s(int x){
    int l=1;
    long long n=x;
    while(n!=1){
        if(n%2==0){
        n=n/2;
        l=l+1;
    }
    else if(n%2!=0){
        n=3*n+1;
        l=l+1;
    }
    }
    return l;
}
int main(){
    int n;
    scanf("%d",&n);
    printf("%d",s(n));
}