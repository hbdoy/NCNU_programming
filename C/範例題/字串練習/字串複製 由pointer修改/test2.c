#include <stdio.h>

char k(char c[],char *copy){
    int i;
    for(i=0;c[i]!=0;i++){
        *copy=c[i];
        copy=copy+1;
    }
    *copy=0;
}

void main(){
    char s[100];
    scanf("%99s",s);
    char copy[100];
    k(s,copy);
    printf("before=%s\n",s);
    printf("copy=%s\n",copy);
}