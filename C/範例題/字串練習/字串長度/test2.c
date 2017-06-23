#include <stdio.h>

int k(char *c){
    int l=0;
    while(*c!=0){
        c=c+1;
        l=l+1;
    }
    return l;
}

void main(){
    char s[100];
    scanf("%99s",s);
    printf("%d\n",k(s));
}