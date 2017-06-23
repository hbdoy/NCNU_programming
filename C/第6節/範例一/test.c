#include <stdio.h>
int A(char c,int l){
    int i;
    for(i=1;i<=l;i=i+1){
        printf("%c",c);
    }
}

int main(){
    int i,n,k;
    scanf("%d",&n);
    for(i=1;i<=n;i=i+1){
        A(' ',n-i);
        A('*',n);
        printf("\n");
    }
}